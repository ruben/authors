package com.example.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Author author;

    private String name;

    public Book(String name) {
        this.name = name;
    }

    public Book() {
//        JPA
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
