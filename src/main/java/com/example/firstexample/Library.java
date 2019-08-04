package com.example.firstexample;

import java.util.List;

public class Library {

    private long id;

    private String name;

    private List<Book> books;

    @Deprecated
    public Library() {
    }

    public Library(long id, String name, List<Book> books) {
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
