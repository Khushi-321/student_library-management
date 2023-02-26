package com.example.student_library_management.controllers;

import com.example.student_library_management.DTOs.BookRequestDTO;
import com.example.student_library_management.models.Book;
import com.example.student_library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDTO bookRequestDTO){
        return bookService.addBook(bookRequestDTO);

    }


}
