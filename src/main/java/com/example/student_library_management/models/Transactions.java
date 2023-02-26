package com.example.student_library_management.models;

import com.example.student_library_management.Enums.TransactionStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value=EnumType.STRING)
    private TransactionStatus transactionStatus;

    private int fine;

    private String transactionId= UUID.randomUUID().toString();


    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssuedOperation;

    @ManyToOne
    @JoinColumn
    private Book book;  // book entities PK will come here
    // and become a foreign key
    // we need to coonect it to card class also

    @ManyToOne
    @JoinColumn
    private Library_card card;

    public Transactions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIssuedOperation() {
        return isIssuedOperation;
    }

    public void setIssuedOperation(boolean issuedOperation) {
        isIssuedOperation = issuedOperation;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Library_card getCard() {
        return card;
    }

    public void setCard(Library_card card) {
        this.card = card;
    }
}
