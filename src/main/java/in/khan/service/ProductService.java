package in.khan.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.khan.entity.ProductEntity;
import in.khan.repositry.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productrepo;

	public Page<ProductEntity> getAllProducts(Pageable pageable) {
		return productrepo.findAll(pageable);
		
		
	}

	public ProductEntity createNewProduct(ProductEntity productentity) {
		return productrepo.save(productentity);

	}

	public ProductEntity updateProduct(Long id, ProductEntity productentity) {
		productentity.setpId(id);
		return productrepo.save(productentity);
	}

	public Optional<ProductEntity> getProductById(Long id) {
		return productrepo.findById(id);
	}

	public String deleteProductById(Long id) {
		productrepo.deleteById(id);
		return "deleted successfully";

	}


	



}
