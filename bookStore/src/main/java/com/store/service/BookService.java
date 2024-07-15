package com.store.service;

import com.store.entities.Book;
import java.util.List;

public interface BookService {
    public int add(Book book);
    public int delete(String isbn);
    public int update(Book book);

    public Book getById(String isbn);
    public List<Book> getAll();

    public List<Book> selectBookByIsbn(String isbn);
    public List<Book> selectBookByAuthor(String author);
    public List<Book> selectBookByTitle(String title);
}
