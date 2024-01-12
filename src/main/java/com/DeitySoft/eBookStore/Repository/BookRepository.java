/**
 * 
 */
package com.DeitySoft.eBookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DeitySoft.eBookStore.Entity.Book;

/**
 * @author pawan
 *
 */
public interface BookRepository extends JpaRepository<Book,Long> {

}
