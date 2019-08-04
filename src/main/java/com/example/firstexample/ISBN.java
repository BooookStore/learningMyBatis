package com.example.firstexample;

public class ISBN {

    private final String rawIsbn;

    public ISBN(String rawIsbn) {
        this.rawIsbn = rawIsbn;
    }

    public String rawIsbn() {
        return rawIsbn;
    }

}
