package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    List<Book> books = new ArrayList<>();

    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author() {
//        JPA
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);

    }
}
