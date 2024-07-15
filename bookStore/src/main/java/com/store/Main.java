package com.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.store.mapper") //import tk.mybatis.spring.annotation.MapperScan;
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
