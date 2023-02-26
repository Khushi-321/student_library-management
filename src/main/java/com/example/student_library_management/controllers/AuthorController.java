package com.example.student_library_management.controllers;

import com.example.student_library_management.DTOs.AuthorEntryDTO;
import com.example.student_library_management.models.Author;
import com.example.student_library_management.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {
    // '/' is optional
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDTO authorEntryDTO){

        return authorService.createAuthor(authorEntryDTO);
    }


}
