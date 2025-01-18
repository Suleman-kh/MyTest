package in.khan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.khan.entity.Category;
import in.khan.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryservice;
	
	@GetMapping("/alldata")
	public List<Category>findAllData(){
		List<Category> allCategory = categoryservice.getAllCategory();
		return allCategory;
	}
	@PostMapping("/createdata")
	public ResponseEntity<Category> createdata(@RequestBody Category category) {
		Category category2 = categoryservice.createCategory(category);
		return new ResponseEntity<>(category2 ,HttpStatus.CREATED);
	}
	
	@GetMapping("/data/{id}")
	public ResponseEntity<Optional<Category>> finddatabyid(@PathVariable Long id){
		return ResponseEntity.ok( categoryservice.getCategoryById(id));
	}
	
	@PutMapping("/updatectg/{id}")
	public ResponseEntity<Category> updatectg(@PathVariable Long id, Category category) {
		return ResponseEntity.ok(categoryservice.updateCategory(id , category));
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedatabyid(@PathVariable Long id) {
		return ResponseEntity.ok(categoryservice.deleteCategory(id));
		
	}

}
