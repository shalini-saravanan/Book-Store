package com.example.bookstore.repository;

import com.example.bookstore.Entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findAllByYearOfPublicationInAndBookTypeIn(Set<String> yop, Set<String> bookType);

    String rawQuery = "select * from book where year_of_publication IN :y_o_p";
    @Query(nativeQuery = true, value = rawQuery)
    List<Book> getBooksByYop(@Param("y_o_p") Set<String> yop);
}
