package com.store.mapper;

import com.store.entities.Author;
import tk.mybatis.mapper.common.Mapper;

public interface AuthorMapper extends Mapper<Author> {

    Author selectAuthorById(Integer id);
    Author selectAuthorsByBookIsbn(String isbn);
    Author insertAuthor(Author author);
    Integer updateAuthor(Author author);
}
