package com.store.service;

import com.store.entities.Author;

import java.util.List;

public interface AuthorService {
    public int add(Author author);
    public int delete(Integer id);
    public int update(Author author);

    public Author getById(Integer id);
    public List<Author> getAll();

    public Author selectAuthorById(Integer id);
}
