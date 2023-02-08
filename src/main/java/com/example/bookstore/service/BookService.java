package com.example.bookstore.service;

import com.example.bookstore.Entity.Book;
import com.example.bookstore.Entity.BookAuthor;
import com.example.bookstore.dto.AuthorDTO;
import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.repository.BookAuthorRepository;
import com.example.bookstore.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookAuthorRepository bookAuthorRepository;


    //Get
    public List<Book> getBooks(Set<String> yop, Set<String> bookType) {
        List<Book> bookList = new ArrayList<>();
        if(yop == null || bookType == null) {
            bookRepository.findAll().forEach(book -> bookList.add(book));
            return bookList;
        }
        else {
            return bookRepository.findAllByYearOfPublicationInAndBookTypeIn(yop, bookType);
        }
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    public Optional<BookDTO> getBookById(Integer bookId, boolean authorData) {
        Optional<Book> book;
        book = bookRepository.findById(bookId);

        BookDTO bookDTO = new BookDTO();
        if(authorData) {
            List<BookAuthor> bookAuthors = bookAuthorRepository.findAllByBookId(bookId);
            log.info(bookAuthors.toString());
            List<AuthorDTO> authorDTOList = new ArrayList<>();
            for(BookAuthor bookAuthor: bookAuthors) {
                AuthorDTO authorDTO = new AuthorDTO();
                log.info(bookAuthor.getAuthor().getName() + "hai");
                authorDTO.setId(bookAuthor.getAuthor().getId());
                authorDTO.setName(bookAuthor.getAuthor().getName());
                authorDTO.setGender(bookAuthor.getAuthor().getGender());
                authorDTOList.add(authorDTO);
            }
            bookDTO.setAuthors(authorDTOList);
        }
        bookDTO.setId(book.get().getId());
        bookDTO.setName(book.get().getName());
        bookDTO.setDescription(book.get().getDescription());
        bookDTO.setYearOfPublication(book.get().getYearOfPublication());
        bookDTO.setBookType((book.get().getBookType()));

        return Optional.of(bookDTO);
    }
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public String deleteBookById(Integer bookId) {
        bookRepository.deleteById(bookId);
        return "Deleted Successfully!";
    }

    public List<Book> getBooksByRawQuery(Set<String> yop) {
        return bookRepository.getBooksByYop(yop);

    }
}
