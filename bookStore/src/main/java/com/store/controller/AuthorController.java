package com.store.controller;

import com.store.entities.Author;
import com.store.resp.*;
import com.store.service.AuthorService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    @Resource
    AuthorService authorService;

    @PostMapping(value = "/author/add")
    public ResultData<String> addPay(@RequestBody Author author)
    {
        System.out.println(author.toString());
        int i = authorService.add(author);
        return ResultData.success("Record inserted successfully, return value:"+i);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/author/del/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = authorService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/author/update")
    public ResultData<String> updatePay(@RequestBody Author author)
    {

        int i = authorService.update(author);
        return ResultData.success("Record updated successfully, return value:"+i);
    }

    @GetMapping(value = "/author/get/{id}")
    public ResultData<Author> getById(@PathVariable("id") Integer id)
    {
        Author author = authorService.selectAuthorById(id);
        return ResultData.success(author);
    }

    //全部查询getall作为家庭作业

    @RequestMapping(value = "/author/error",method = RequestMethod.GET)
    public ResultData<Integer> getPayError()
    {
        Integer i = Integer.valueOf(200);
        try
        {
            System.out.println("--------come here");
            int data = 10/0;
        }catch (Exception e){
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return ResultData.success(i);
    }
}
