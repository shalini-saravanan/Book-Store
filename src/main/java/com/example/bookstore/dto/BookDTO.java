package com.example.bookstore.dto;

import com.example.bookstore.Entity.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookDTO {
    private int id;
    private String name;
    private String description;
    private String yearOfPublication;
    private String bookType;
    private List<AuthorDTO> authors;
}
