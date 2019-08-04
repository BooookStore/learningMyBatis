package com.example.firstexample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FirstExampleTest {

    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        properties.load(Resources.getResourceAsStream("mybatis.properties"));

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis-config.xml"),
                properties
        );

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        bookMapper.insertBook(new Book(1L, "DomainDrivenDesign", new ISBN("12345")));
        Optional<Book> findBook = bookMapper.selectBook(1L);

        Book book = findBook.orElse(null);
        assertNotNull(book);
        assertEquals(1L, book.id());
        assertEquals("DomainDrivenDesign", book.title());
        assertEquals("12345", book.isbn().rawIsbn());

        sqlSession.close();
    }

}