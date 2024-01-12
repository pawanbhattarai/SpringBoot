/**
 * 
 */
package com.DeitySoft.eBookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DeitySoft.eBookStore.Entity.Category;

/**
 * @author pawan
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

	boolean existsByCategoryName(String category_name);
}
