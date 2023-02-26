package com.example.student_library_management.Repositories;

import com.example.student_library_management.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {

    @Query(value= "select * from transactions t where t.book_id = :bookId and t.card_id=:cardId and is_issued_operation=true" ,nativeQuery = true )
    List<Transactions> getTransactionforBookandCard(int bookId, int cardId);


}
