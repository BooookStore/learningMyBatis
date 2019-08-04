package com.example.firstexample;

import java.util.Optional;

interface BookMapper {

    Optional<Book> selectBook(Long id);

    void insertBook(Book book);

}
