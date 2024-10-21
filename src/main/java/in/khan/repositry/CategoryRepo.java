package in.khan.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import in.khan.entity.Category;

public interface CategoryRepo  extends JpaRepository<Category , Long>{

}
