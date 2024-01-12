package com.DeitySoft.eBookStore.Controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.DeitySoft.eBookStore.Entity.Book;
import com.DeitySoft.eBookStore.Entity.Category;  // Import Category class
import com.DeitySoft.eBookStore.Service.BookService;
import com.DeitySoft.eBookStore.Service.CategoryService;

import java.util.Set;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    private final BookService bookServ;
    private final CategoryService categoryService;

    @Autowired  // Add @Autowired for constructor injection
    public BookController(BookService bookServ,CategoryService categoryService ) {
        this.bookServ = bookServ;
		this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Book> findAll() {
        return bookServ.getAllBooks();
    }

    @PostMapping("/add")
    public List<Book> addBook(@RequestBody Book book) {  // Add @RequestBody annotation
        bookServ.addBook(book);
        return bookServ.getAllBooks();
    }

    @PostMapping("/delete")
    public List<Book> deleteBook(@RequestParam Long id) {  // Add @RequestParam annotation
        bookServ.deleteBookById(id);
        return bookServ.getAllBooks();
    }

    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(
            @RequestParam("coverFile") MultipartFile coverFile,
            @RequestParam("bookFile") MultipartFile bookFile,
            @RequestParam("b_name") String b_name,
            @RequestParam("author") String author,
            @RequestParam("whoUser") String whoUser,
            @RequestParam("categoryIds") Set<Long> categoryIds) throws IOException {  // Assuming categoryIds is a Set of Long
        // Fetch categories from the database based on categoryIds
        Set<Category> categories = fetchCategoriesByIds(categoryIds);

        // Save the book
        Book savedBook = bookServ.saveBook(coverFile, bookFile, b_name, author, whoUser, categories);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
    private Set<Category> fetchCategoriesByIds(Set<Long> categoryIds) {
        Set<Category> categories = new HashSet<>();

        for (Long categoryId : categoryIds) {
            Category category = categoryService.getCategoryById(categoryId);
            if (category != null) {
                categories.add(category);
            }
        }

        return categories;
    }
}
