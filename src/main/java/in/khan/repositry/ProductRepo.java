package in.khan.repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.khan.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity , Long> {
	 @Query("SELECT p FROM ProductEntity p JOIN FETCH p.category WHERE p.id = :productId")
	 Optional<ProductEntity>findProductWithCategory(Long productId);
	


}
