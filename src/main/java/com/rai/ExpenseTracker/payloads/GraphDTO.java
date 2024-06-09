package com.rai.ExpenseTracker.payloads;

import com.rai.ExpenseTracker.model.Expense;
import com.rai.ExpenseTracker.model.Income;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;

    private List<Income> incomeList;

}

