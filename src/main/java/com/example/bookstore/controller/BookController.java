package com.example.bookstore.controller;

import com.example.bookstore.Entity.Book;
import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books")
    public List<Book> getBooks(@RequestParam(value = "yearOfPublications", required = false) Set<String> yop,
                               @RequestParam(value = "bookType", required = false) Set<String> bookType) {
        return bookService.getBooks(yop, bookType);
    }
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Optional<BookDTO> getBookById(@PathVariable("id") Integer bookId, @RequestParam(value = "authorData", required = false) boolean authorData) {
        return bookService.getBookById(bookId, authorData);
    }
    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }
    @RequestMapping(value="books/{id}", method = RequestMethod.DELETE)
    public String deleteBookById(@PathVariable("id") Integer bookId) {
        return bookService.deleteBookById(bookId);
    }
    @RequestMapping(value="/raw/books", method = RequestMethod.GET)
    public List<Book> getBookByRawQuery(@RequestParam(value = "yop", required = false) Set<String> yop) {
        return bookService.getBooksByRawQuery(yop);
    }

}
