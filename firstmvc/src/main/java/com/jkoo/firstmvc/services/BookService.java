package com.jkoo.firstmvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.jkoo.firstmvc.models.Book;
import com.jkoo.firstmvc.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    		Optional<Book> checkbook = bookRepository.findById(id);
    		if(checkbook.isPresent()) {
                Book updatebook = checkbook.get();
                updatebook.setTitle(title);
                updatebook.setDescription(desc);
                updatebook.setLanguage(lang);
                updatebook.setNumberOfPages(numOfPages);
                return bookRepository.save(updatebook);
            } else {
                return null;
            }
    }
    
    public void deleteBook(Long id) {
    		Optional<Book> checkbook = bookRepository.findById(id);
		if(checkbook.isPresent()) {
    			bookRepository.deleteById(id);
		}
    }
}
