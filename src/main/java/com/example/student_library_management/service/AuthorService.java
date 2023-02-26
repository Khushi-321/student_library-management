package com.example.student_library_management.service;

import com.example.student_library_management.DTOs.AuthorEntryDTO;
import com.example.student_library_management.Repositories.AuthorRepository;
import com.example.student_library_management.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String createAuthor(AuthorEntryDTO authorEntryDTO){

        // the important step is :
        //in params object is of type  DTO but repository interacts only with
        // entities

        // solution to this is convert author entry DTO ----> Author
        // created an object of type author
        // we are setting it's attributes so that we can save correct values in DB
        // repository layer is always connected to entity only
        // so that is why to save it we convert is from DTO to entity
        Author author= new Author();
        author.setName(authorEntryDTO.getName());
        author.setAge(authorEntryDTO.getAge());
        author.setCountry(authorEntryDTO.getCountry());
        author.setRating(authorEntryDTO.getRating());




        authorRepository.save(author);
        return "Author added successfully";

    }

}
