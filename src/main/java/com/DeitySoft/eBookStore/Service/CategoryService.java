/**
 * 
 */
package com.DeitySoft.eBookStore.Service;

import java.util.List;

import com.DeitySoft.eBookStore.Entity.Category;

/**
 * @author pawan
 *
 */
public interface CategoryService {

	List<Category> getAllCategory();

	Category saveCategory(Category category);

	Category updateCategory(Category category);

	void deleteCategoryById(Long id);

	boolean existsCategoryByName(String categoryName);

	Category getCategoryById(Long id);

}
