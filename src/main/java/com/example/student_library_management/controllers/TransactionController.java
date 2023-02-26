package com.example.student_library_management.controllers;

import com.example.student_library_management.DTOs.IssueBookRequestDTO;
import com.example.student_library_management.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDTO issueBookRequestDTO){
        try{
            return transactionService.issueBook(issueBookRequestDTO);
        } catch (Exception e){
            return e.getMessage();
        }

        // this information will be send from bakcend to final user
    }

    @GetMapping("getTxnInfo")
    public String getTransactionInfo(@RequestParam("bookId") int bookId, @RequestParam("cardId") int cardId){
        return transactionService.getTransaction(bookId,cardId);
    }
}
