/**
 * 
 */
package com.DeitySoft.eBookStore.ServiceImpl;

import com.DeitySoft.eBookStore.Repository.BookRepository;
import com.DeitySoft.eBookStore.Service.BookService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.DeitySoft.eBookStore.Entity.Book;
import com.DeitySoft.eBookStore.Entity.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author pawan
 *
 */
@Service
public class BookServiceImpl implements BookService{
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
	private BookRepository BookRepo;

	public BookServiceImpl(BookRepository bookRepo) {
		super();
		BookRepo = bookRepo;
	}
	
	@Override
    public Book saveBook(MultipartFile coverFile, MultipartFile bookFile, String b_name, String author, String whoUser, Set<Category> categories) throws java.io.IOException {
        // Save the file data to the server's filesystem
        String coverPath = saveFileToDisk(coverFile, "covers");
        String bookPath = saveFileToDisk(bookFile, "books");

        // Create a new Book entity
        Book book = new Book();
        book.setB_name(b_name);
        book.setAuthor(author);
        book.setCover(coverPath);
        book.setBook(bookPath);
        book.setWhoUser(whoUser);
        book.setCategories(categories);

        // Save the Book entity
        return BookRepo.save(book);
    }

    private String saveFileToDisk(MultipartFile file, String folder) throws java.io.IOException {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = Paths.get("http://localhost:8083", "bookDetail", fileName).toString();

        try {
            Path destinationPath = Paths.get(filePath);
            Files.copy(file.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            return filePath;
        } catch (IOException e) {
            log.error("Failed to store file to disk", e);
            throw new RuntimeException("Failed to store file to disk: " + e.getMessage(), e);
        }
    }
	
	
	@Override
	public List<Book> getAllBooks(){
		return BookRepo.findAll();
	}
	@Override
	public Book addBook(Book book) {
		return BookRepo.save(book);
	}
	@Override
	public Book updateBook(Book book) {
		return BookRepo.save(book);
	}
	@Override
	public void deleteBookById(Long id) {
		BookRepo.deleteById(id);
	}
	

	
}
