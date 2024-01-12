/**
 * 
 */
package com.DeitySoft.eBookStore.ServiceImpl;

import org.springframework.stereotype.Service;

import com.DeitySoft.eBookStore.Entity.Category;
import com.DeitySoft.eBookStore.Repository.CategoryRepository;
import com.DeitySoft.eBookStore.Service.CategoryService;
import java.util.List;
import java.util.Optional;

/**
 * @author pawan
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService{
	private CategoryRepository categoryRepo;

	public CategoryServiceImpl(CategoryRepository categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}
	@Override
	public List<Category> getAllCategory(){
		return categoryRepo.findAll();
	}
	@Override
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}
	@Override
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
	@Override
	public void deleteCategoryById(Long id) {
		categoryRepo.deleteById(id);
	}
	@Override
	public boolean existsCategoryByName(String categoryName) {
        System.out.println("Checking if category exists: " + categoryName);
        return categoryRepo.existsByCategoryName(categoryName);
    }
	@Override
	public Category getCategoryById(Long id) {
	    Optional<Category> categoryOptional = categoryRepo.findById(id);
	    return categoryOptional.orElse(null);
	}
	
}
