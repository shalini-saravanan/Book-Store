package com.example.bookstore.repository;

import com.example.bookstore.Entity.BookAuthor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorRepository extends CrudRepository<BookAuthor, Integer> {
    List<BookAuthor> findAllByBookId(int bookId);
}
