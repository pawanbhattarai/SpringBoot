/**
 * 
 */
package com.DeitySoft.eBookStore.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeitySoft.eBookStore.Entity.Category;
import com.DeitySoft.eBookStore.Service.CategoryService;

/**
 * @author pawan
 *
 */
@RestController
@RequestMapping("/Category")
@CrossOrigin
public class CategoryController {
	private CategoryService categoryServ;

	public CategoryController(CategoryService categoryServ) {
		super();
		this.categoryServ = categoryServ;
	}
	@GetMapping("/All")
	public List<Category> getAllCategory(){
		return categoryServ.getAllCategory();
	}
	@PostMapping("/add")
	public ResponseEntity<?> saveCategory(@RequestBody Category category) {
	    String categoryName = category.getCategoryName();
	    if (categoryServ.existsCategoryByName(categoryName)) {
	        System.out.println("Category with this name already exists");
	        return new ResponseEntity<>("Category with this name already exists", HttpStatus.BAD_REQUEST);
	    } else {
	        System.out.println("Saving category: " + category);
	        categoryServ.saveCategory(category);
	        return ResponseEntity.ok(categoryServ.getAllCategory());
	    }
	}
	@PostMapping("/delete")
	public List<Category> saveCategory(@RequestBody Long id){
		 categoryServ.deleteCategoryById(id);
		 return categoryServ.getAllCategory();
	}
	@PostMapping("/update")
	public List<Category> updateCategory(@RequestBody Category category){
		 categoryServ.saveCategory(category);
		 return categoryServ.getAllCategory();
	}	
	
}
