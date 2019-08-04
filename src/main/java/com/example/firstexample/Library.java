package com.example.firstexample;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private Long id;

    private String name;

    private List<Book> books;

    public Library(Long id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public Library(Long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public List<Book> books() {
        return books;
    }
}
