package com.example.student_library_management.service;


import com.example.student_library_management.DTOs.IssueBookRequestDTO;
import com.example.student_library_management.Enums.CardStatus;
import com.example.student_library_management.Enums.TransactionStatus;
import com.example.student_library_management.Repositories.BookRepository;
import com.example.student_library_management.Repositories.CardRepository;
import com.example.student_library_management.Repositories.TransactionRepository;
import com.example.student_library_management.models.Book;
import com.example.student_library_management.models.Library_card;
import com.example.student_library_management.models.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;


    public String issueBook(IssueBookRequestDTO issueBookRequestDTO) throws Exception{

        int bookId= issueBookRequestDTO.getBookId();
        int cardId=issueBookRequestDTO.getCardId();


        // get book and card entity
        // what is the benefit of getting these two entities
        // because I want to set transaction attributes

        Book book= bookRepository.findById(bookId).get();
        Library_card card= cardRepository.findById(cardId).get();

        // final goal is to make a transaction entity  set its attributes
        // and save it


        Transactions transactions= new Transactions();
        // setting attributes
        transactions.setBook(book);
        transactions.setCard(card);

        transactions.setTransactionId(UUID.randomUUID().toString());

        transactions.setIssuedOperation(true);
        transactions.setTransactionStatus(TransactionStatus.PENDING);

        // attribute left is success/fail
        // check for validations
        if(book==null || book.isIssued()==true){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Book is not available");
        }

        if(card==null || ( card.getCardStatus()!=CardStatus.ACTIVATED )){
            transactionRepository.save(transactions);
            transactions.setTransactionStatus((TransactionStatus.FAILED));
            throw new Exception("Card is not valid");
    
        }

        // we have reached a success case now


        transactions.setTransactionStatus((TransactionStatus.SUCCESS));
        // here we are performing 3 steps
        // getting list of transactions
        // adding current transactions
        // setting it back

        // Now I will need to do changes in card and book

        // set attributes of book

        book.setIssued(true);
        // between book and transaction: bidirectional
        List<Transactions> listOftransactionsForbook=book.getListOfTransactions();
        listOftransactionsForbook.add(transactions);
        book.setListOfTransactions(listOftransactionsForbook);

        // I need to make changes in card also

        List<Book> issuedBookforCards= card.getBooksIssued();
        issuedBookforCards.add(book);

        card.setBooksIssued(issuedBookforCards);

        // Between card and transactions : bidirectional (Parent class)
        List<Transactions> transactionListForcard= card.getList();
        transactionListForcard.add(transactions);
        card.setList(transactionListForcard);


        // save parent object
        cardRepository.save(card);

        // automatically by cascading book and transaction will be
        // saved if we are saving parent



        return "Book issued successfully";
// write issue book yourself

    }

    public  String getTransaction(int bookId, int cardId) {
        List<Transactions> transactionsList = transactionRepository.getTransactionforBookandCard(bookId, cardId);
        String transactionId = transactionsList.get(0).getTransactionId();
        return transactionId;
    }


}
