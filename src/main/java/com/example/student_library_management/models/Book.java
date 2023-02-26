package com.example.student_library_management.models;

import com.example.student_library_management.Enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pages;


    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    // Book is child class
    // Setting here the foreign key : standard 3 types
    @ManyToOne // mapping
    @JoinColumn // Add an extra attribute of author ID(parent table PK) for foreign key of child table
    private Author author; // this is parent entity we are connecting with

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    // mapping card and book
    //  book is also child with respect to card....
    @ManyToOne
    @JoinColumn
    private Library_card card;
    private boolean isIssued;


    // mapping with transaction class
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transactions> listOfTransactions= new ArrayList<>();


    public Book() {
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Library_card getCard() {
        return card;
    }

    public void setCard(Library_card card) {
        this.card = card;
    }

    public List<Transactions> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transactions> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }
}
