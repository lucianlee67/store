package com.store.service.impl;

import com.store.entities.Author;
import com.store.mapper.AuthorMapper;
import com.store.service.AuthorService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Resource
    AuthorMapper authorMapper;
    @Override
    public int add(Author author){
        return authorMapper.insertSelective(author);
    }
    @Override
    public int delete(Integer id){
        return authorMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int update(Author author){
        return authorMapper.updateAuthor(author);
    }
    @Override
    public Author getById(Integer id){
        return authorMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<Author> getAll(){
        return authorMapper.selectAll();
    }

    @Override
    public Author selectAuthorById(Integer id)
    {
        return authorMapper.selectAuthorById(id);
    }
    public Author insertAuthor(Author author){
        return authorMapper.insertAuthor(author);
    }

}
