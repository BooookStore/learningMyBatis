package com.example.firstexample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class FirstExampleTest {

    private static SqlSession sqlSession;

    @BeforeClass
    public static void beforeClass() throws IOException {
        Properties properties = new Properties();
        properties.load(Resources.getResourceAsStream("mybatis.properties"));

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis-config.xml"),
                properties
        );

        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void after() {
        sqlSession.rollback();
    }

    @AfterClass
    public static void afterClass() {
        sqlSession.close();
    }

    @Test
    public void bookInsertAndRetrieve() {
        LibraryMapper libraryMapper = sqlSession.getMapper(LibraryMapper.class);
        libraryMapper.insertLibrary(new Library(1L, "Kawaguich", new ArrayList<>()));
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        bookMapper.insertBook(1L, new Book(1L, "DomainDrivenDesign", new ISBN("12345")));
        Optional<Book> findBook = bookMapper.selectBook(1L);

        Book book = findBook.orElse(null);
        assertNotNull(book);
        assertEquals(1L, book.id());
        assertEquals("DomainDrivenDesign", book.title());
        assertEquals("12345", book.isbn().rawIsbn());
    }

    @Test
    public void bookInsertAndFind() {
        LibraryMapper libraryMapper = sqlSession.getMapper(LibraryMapper.class);
        libraryMapper.insertLibrary(new Library(1L, "Kawaguich", new ArrayList<>()));
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        bookMapper.insertBook(1L, new Book(1L, "DomainDrivenDesign", new ISBN("12345")));
        bookMapper.insertBook(1L, new Book(2L, "DomainDrivenDesign", new ISBN("12346")));

        List<Book> books = bookMapper.findByTitle("DomainDrivenDesign");
        assertEquals(2, books.size());
        assertEquals(1L, books.get(0).id());
        assertEquals(2L, books.get(1).id());
    }

    @Test
    public void libraryInsertAndFind() {
        Library library = new Library(1L, "Kawaguich", new ArrayList<>(Arrays.asList(
                new Book(1L, "A", new ISBN("12345")),
                new Book(2L, "B", new ISBN("12345")),
                new Book(3L, "C", new ISBN("12345"))
        )));

        LibraryMapper libraryMapper = sqlSession.getMapper(LibraryMapper.class);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        libraryMapper.insertLibrary(library);
        library.books().forEach(book -> bookMapper.insertBook(library.id(), book));

        Optional<Library> findLibrary = libraryMapper.findById(1L);
        Library notNullLibrary = findLibrary.orElse(null);
        assertNotNull(notNullLibrary);
        assertEquals(3, notNullLibrary.books().size());
        assertEquals(1L, notNullLibrary.books().get(0).id());

        Optional<Library> nullLibrary = libraryMapper.findById(2L);
        assertNull(nullLibrary.orElse(null));
    }

}