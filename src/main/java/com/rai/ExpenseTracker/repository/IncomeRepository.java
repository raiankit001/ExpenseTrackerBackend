package com.rai.ExpenseTracker.repository;

import com.rai.ExpenseTracker.model.Expense;
import com.rai.ExpenseTracker.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Integer> {

    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(i.amount) FROM Income i")
    Double sumAllAmount();

    Optional<Income> findFirstByOrderByDateDesc();

}
