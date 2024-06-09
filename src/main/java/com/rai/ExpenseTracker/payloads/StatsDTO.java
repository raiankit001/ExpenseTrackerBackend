package com.rai.ExpenseTracker.payloads;

import com.rai.ExpenseTracker.model.Expense;
import com.rai.ExpenseTracker.model.Income;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatsDTO {

    private double income;

    private double expense;

    private Income latestIncome;

    private Expense latestExpense;

    private double balance;

    private double minIncome;

    private double maxIncome;

    private double minExpense;

    private double maxExpense;


}
