package in.khan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.khan.entity.Category;
import in.khan.repositry.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryrepo;

	public List<Category> getAllCategory() {
		List<Category> all = categoryrepo.findAll();
		return all;
	}

	public Category createCategory(Category category) {
		return categoryrepo.save(category);
	
	}

	public Category updateCategory(Long id, Category category) {
		category.setcId(id);
		return categoryrepo.save(category);
	}

	public Optional<Category> getCategoryById(Long id) {
		return categoryrepo.findById(id);
	}

	public String  deleteCategory(Long id) {
		categoryrepo.deleteById(id);
		return "deleted successfully";
		
	}

}
