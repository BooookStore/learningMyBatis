package com.example.firstexample;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

interface BookMapper {

    Optional<Book> findById(Long id);

    List<Book> findByTitle(String title);

    void insertBook(@Param("libraryId") Long libraryId, @Param("book") Book book);

}
