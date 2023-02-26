package com.example.student_library_management.DTOs;

public class IssueBookRequestDTO {

    private int bookId;
    private int cardId;

    public IssueBookRequestDTO(int bookId, int cardId) {
        this.bookId = bookId;
        this.cardId = cardId;
    }

    public IssueBookRequestDTO() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
