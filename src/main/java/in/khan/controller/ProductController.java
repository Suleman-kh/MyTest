package in.khan.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.khan.entity.Category;
import in.khan.entity.ProductEntity;
import in.khan.repositry.CategoryRepo;
import in.khan.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@Autowired
	private CategoryRepo categoryrepo;
	
	@GetMapping("/products")
	public Page<ProductEntity>getalldata(
			@RequestParam (defaultValue = "0") int paze ,
			@RequestParam (defaultValue = "10") int size){
		Pageable pageable = (Pageable) PageRequest.of(paze, size);
		return productservice.getAllProducts(pageable);
		
	}
	
	
	@PostMapping("/createNewProduct")
	public ResponseEntity<ProductEntity> createdata(@RequestBody ProductEntity productentity) {
		 Category category = categoryrepo.findById(productentity.getCategory().getcId())
                 .orElseThrow(() -> new RuntimeException("Category not found"));
		
		productentity.setCategory(category);
		ProductEntity product = productservice.createNewProduct(productentity);
		return new ResponseEntity<>(product , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getdatawithid/{productId}")
	public ResponseEntity<ProductEntity>getdataid(@PathVariable Long productId){
		ProductEntity entity = productservice.getdatawithid(productId);
		return new ResponseEntity<>(entity , HttpStatus.OK);
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
