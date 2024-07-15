package com.store.controller;

import com.store.entities.Book;
import com.store.resp.ResultData;
import com.store.resp.ReturnCodeEnum;
import com.store.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Resource
    BookService bookService;

    @PostMapping(value = "/book/add")
    public ResultData<String> addPay(@RequestBody Book book)
    {
        System.out.println(book.toString());
        int i = bookService.add(book);
        return ResultData.success("Record inserted successfully, return value:"+i);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/book/del/{isbn}")
    public ResultData<Integer> deletePay(@PathVariable("isbn") String isbn) {
        int i = bookService.delete(isbn);
        return ResultData.success(i);
    }

    @PutMapping(value = "/book/update")
    public ResultData<String> updatePay(@RequestBody Book book)
    {

        int i = bookService.update(book);
        return ResultData.success("Record updated successfully, return value:"+i);
    }

    @GetMapping(value = "/book/get/{isbn}")
    public ResultData<List<Book>> getById(@PathVariable("isbn") String isbn)
    {
        List<Book> book = bookService.selectBookByIsbn(isbn);
        return ResultData.success(book);
    }

    @GetMapping(value = "/book/get/title/{title}")
    public ResultData<List<Book>> getByTittle(@PathVariable("title") String title)
    {
        List<Book> book = bookService.selectBookByTitle(title);
        return ResultData.success(book);
    }


    @RequestMapping(value = "/book/error",method = RequestMethod.GET)
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
