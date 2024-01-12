/**
 * 
 */
package com.DeitySoft.eBookStore.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.DeitySoft.eBookStore.Entity.Book;
import com.DeitySoft.eBookStore.Entity.Category;

/**
 * @author pawan
 *
 */
public interface BookService {

	List<Book> getAllBooks();

	Book addBook(Book book);

	Book updateBook(Book book);

	void deleteBookById(Long id);

	Book saveBook(MultipartFile coverFile, MultipartFile bookFile, String b_name, String author, String whoUser,
			Set<Category> categories) throws IOException;
	
	

}
