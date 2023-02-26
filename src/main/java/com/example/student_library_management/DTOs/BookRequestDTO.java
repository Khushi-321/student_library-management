package com.example.student_library_management.DTOs;

import com.example.student_library_management.Enums.Genre;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class BookRequestDTO {

    private String name;
    private int pages;
    private Genre genre;
    private int authorId;

    public BookRequestDTO(String name, int pages, Genre genre, int authorId) {
        this.name = name;
        this.pages = pages;
        this.genre = genre;
        this.authorId = authorId;
    }

    public BookRequestDTO() {
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
