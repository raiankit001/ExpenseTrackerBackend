package com.rai.ExpenseTracker.service.expense;

import com.rai.ExpenseTracker.payloads.ExpenseDTO;
import com.rai.ExpenseTracker.model.Expense;

import java.util.List;

public interface ExpenseService {

    ExpenseDTO saveExpense(ExpenseDTO expenseDTO);

    List<ExpenseDTO> getAllExpense();

    ExpenseDTO getExpenseById(Integer id);

    ExpenseDTO updateExpense(Integer expId, ExpenseDTO expenseDTO);

    void deleteExpense(Integer expId);

}

