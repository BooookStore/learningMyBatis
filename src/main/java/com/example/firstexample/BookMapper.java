package com.example.firstexample;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

interface BookMapper {

    Optional<Book> selectBook(Long id);

    void insertBook(@Param("libraryId") Long libraryId, @Param("book") Book book);

    List<Book> findByTitle(String title);

}
