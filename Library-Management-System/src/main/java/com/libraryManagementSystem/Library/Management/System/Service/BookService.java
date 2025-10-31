package com.libraryManagementSystem.Library.Management.System.Service;

import com.libraryManagementSystem.Library.Management.System.Entity.Book;
import com.libraryManagementSystem.Library.Management.System.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById (String id){
        return bookRepository.findById(id);
    }

    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }

    public List<Book> searchByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> searchByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> searchByCategory(String category){
        return bookRepository.findByCategory(category);
    }
}
