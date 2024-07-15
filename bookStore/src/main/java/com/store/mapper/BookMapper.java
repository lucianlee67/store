package com.store.mapper;

import com.store.entities.Author;
import com.store.entities.Book;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookMapper extends Mapper<Book> {
    List<Book> selectBookByIsbn(String isbn);
    List<Book> selectBookByTitle(String title);
    Integer insertBook(Book book);
    Integer updateBook(Book book);
    Integer insertBookAuthors(@Param("bookIsbn") String bookIsbn, @Param("authorId") Integer authorId);
    Integer deleteBook(String isbn);
    Integer deleteBookAuthorsByBookIsbn(String isbn);

}
