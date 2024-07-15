package com.store.service.impl;

import com.store.entities.Author;
import com.store.entities.Book;
import com.store.mapper.AuthorMapper;
import com.store.mapper.BookMapper;
import com.store.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;
    @Resource
    AuthorMapper authorMapper;

    @Override
    public int add(Book book){
        Integer count = bookMapper.insertBook(book);
        // Insert each author and the corresponding book-author relationship
        for (Author author : book.getAuthors()) {
            // Check if author exists and insert if necessary (implement this logic as needed)
            authorMapper.insertSelective(author);
            bookMapper.insertBookAuthors(book.getIsbn(), author.getId());
        }
        return count;
    }
    @Override
    public int delete(String isbn){
        bookMapper.deleteBookAuthorsByBookIsbn(isbn);
        return bookMapper.deleteBook(isbn);

    }

    @Override
    public int update(Book book){
        for (Author author : book.getAuthors()) {
            // Check if author exists and insert if necessary (implement this logic as needed)
            authorMapper.updateAuthor(author);
        }
        return bookMapper.updateBook(book);
    }
    @Override
    public Book getById(String isbn){
        return bookMapper.selectByPrimaryKey(isbn);
    }
    @Override
    public List<Book> getAll(){
        return bookMapper.selectAll();
    }

    @Override
    public List<Book> selectBookByIsbn(String isbn){
        return bookMapper.selectBookByIsbn(isbn);
    }

    @Override
    public List<Book> selectBookByAuthor(String author) {
        return List.of();
    }

    @Override
    public List<Book> selectBookByTitle(String title) {
        return bookMapper.selectBookByTitle(title);
    }

}
