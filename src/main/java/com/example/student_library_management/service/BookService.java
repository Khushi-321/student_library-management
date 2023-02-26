package com.example.student_library_management.service;

import com.example.student_library_management.DTOs.BookRequestDTO;
import com.example.student_library_management.Repositories.AuthorRepository;
import com.example.student_library_management.models.Author;
import com.example.student_library_management.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRespository;

    public String addBook(BookRequestDTO bookRequestDTO){
        // I want to get the author entity??
        int authorId= bookRequestDTO.getAuthorId();

        // I will be fetching author entity
        Author author= authorRespository.findById(authorId).get();
        // We have created this entity so that we can save it into the DB
        Book book= new Book();
        // basic attributes are being set from DTO to Entity layer

        book.setGenre(bookRequestDTO.getGenre());
        book.setIssued(false);
        book.setName(bookRequestDTO.getName());
        book.setPages(bookRequestDTO.getPages());


        // HW do exception handling
        // because in case if there is nothing above statement will throw exception
        // basic attributs are already set from postman

        // Setting foreign key attribute in child class
        book.setAuthor(author);

        // we need to also update list of books written in parent class

        List<Book> currentBooksWritten=author.getBooksWritten();
        currentBooksWritten.add(book);
        author.setBooksWritten(currentBooksWritten);

        // now book is to be saved but also author is also to be saved
        // Why do we again need to save(updating author) author? Because author
        // entity has been updated...... we need to resave it or update it

        authorRespository.save(author); // data was modified
        // .save function works both as save function and update function

        // bookrepo. save is not required because it will be auto called by cascading
        // effect

        return "book added successfully";


    }
}
