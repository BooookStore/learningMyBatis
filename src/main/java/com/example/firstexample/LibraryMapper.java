package com.example.firstexample;

import java.util.Optional;

public interface LibraryMapper {

    void insertLibrary(Library library);

    Optional<Library> findById(long id);

}
