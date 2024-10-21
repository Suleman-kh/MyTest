package in.khan.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.khan.entity.ProductEntity;
import in.khan.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	@GetMapping("/products")
	public Page<ProductEntity>getalldata(
			@RequestParam (defaultValue = "0") int paze ,
			@RequestParam (defaultValue = "10") int size){
		Pageable pageable = (Pageable) PageRequest.of(paze, size);
		return productservice.getAllProducts(pageable);
		
	}
	
	
	@PostMapping("/createNewProduct")
	public ProductEntity createdata(@RequestBody ProductEntity productentity) {
		return  productservice.createNewProduct(productentity);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Optional<ProductEntity>> finddatabyid(@PathVariable Long id){
		return ResponseEntity.ok(productservice.getProductById(id));
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<ProductEntity> updatectg(@PathVariable Long id, ProductEntity productentity) {
		return ResponseEntity.ok( productservice.updateProduct(id, productentity));
	
	}
	
	@DeleteMapping("/deleteproductbyid/{id}")
	public ResponseEntity<String> deletedatabyid(@PathVariable Long id) {
		return ResponseEntity.ok( productservice.deleteProductById(id));
		
	}

}
