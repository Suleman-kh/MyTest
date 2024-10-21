package in.khan.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import in.khan.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity , Long> {

}
