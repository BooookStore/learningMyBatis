package com.example.firstexample;

public class Book {

    private final long id;

    private String title;

    private final ISBN isbn;

    public Book(long id, String title, ISBN isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    public long id() {
        return id;
    }

    public String title() {
        return title;
    }

    public ISBN isbn() {
        return isbn;
    }

}
