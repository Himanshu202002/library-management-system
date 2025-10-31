package com.libraryManagementSystem.Library.Management.System.Controller;

import com.libraryManagementSystem.Library.Management.System.Entity.Book;
import com.libraryManagementSystem.Library.Management.System.Service.BookService;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Get all Books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    //Get Book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookByID(@PathVariable String id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    //Create or Update book
    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    //Delete Book
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book Deleted Successfully");
    }

    //Search By author
    @GetMapping("/search/author/{author}")
    public ResponseEntity<List<Book>> searchByAuthor(@PathVariable String author){
        return ResponseEntity.ok(bookService.searchByAuthor(author));
    }

    //Search By Title
    @GetMapping("/search/title/{title}")
    public ResponseEntity<List<Book>> searchByTitle(@PathVariable String title){
        return ResponseEntity.ok(bookService.searchByTitle(title));
    }

    //Search By category
    @GetMapping("search/category/{category}")
    public ResponseEntity<List<Book>> searchByCategory(@PathVariable String category){
        return ResponseEntity.ok(bookService.searchByCategory(category));
    }
}
