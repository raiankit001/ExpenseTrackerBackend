package com.rai.ExpenseTracker.repository;

import com.rai.ExpenseTracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {

    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);



    @Query("SELECT SUM(e.amount) FROM Expense e")
    Double sumAllAmount();


    Optional<Expense> findFirstByOrderByDateDesc();
}
