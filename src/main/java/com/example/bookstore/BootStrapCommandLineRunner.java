package com.example.bookstore;

import com.example.bookstore.Entity.Author;
import com.example.bookstore.Entity.Book;
import com.example.bookstore.Entity.BookAuthor;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookAuthorRepository;
import com.example.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
@Slf4j
public class BootStrapCommandLineRunner implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private BookAuthorRepository bookAuthorRepository;
    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book(1, "Harry Potter", "A series of 7 Fantasy Novels!", "2007", "Fictional Novel");
        Book book2 = new Book(2, "A Girl in Room 105", "An Unlove Story!", "2018", "Mystery, Thriller");
        Book book3 = new Book(3, "The Talisman", "Explore a parallel universe!", "1984", "Horror Fiction");

        Author author1 = new Author(1, "J K Rowling", "Female",new Date(), new Date());
        Author author2 = new Author(2, "Chetan Bhagat", "Male", null, null);
        Author author3 = new Author(3, "Stephen King", "Male", null, null);
        Author author4 = new Author(4, "Peter Straub", "Male", null, null);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);
        authorRepository.save(author4);

        bookAuthorRepository.save(new BookAuthor(1, book1, author1));
        bookAuthorRepository.save(new BookAuthor(2, book2, author2));
        bookAuthorRepository.save(new BookAuthor(3, book3, author3));
        bookAuthorRepository.save(new BookAuthor(4, book3, author4));

    }
}
