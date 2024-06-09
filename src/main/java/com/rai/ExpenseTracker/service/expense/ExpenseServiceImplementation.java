package com.rai.ExpenseTracker.service.expense;

import com.rai.ExpenseTracker.exceptions.ResourceNotFoundException;
import com.rai.ExpenseTracker.payloads.ExpenseDTO;
import com.rai.ExpenseTracker.model.Expense;
import com.rai.ExpenseTracker.repository.ExpenseRepository;
import com.rai.ExpenseTracker.service.expense.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class ExpenseServiceImplementation implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ExpenseDTO saveExpense(ExpenseDTO expenseDTO) {
        Expense expense = expenseRepository.save( modelMapper.map(expenseDTO,Expense.class));
        return modelMapper.map(expense,ExpenseDTO.class);
    }

    @Override
    public List<ExpenseDTO> getAllExpense() {
        List<Expense> expenseList = expenseRepository.findAll();
        List<ExpenseDTO> expenseDTOList = expenseList.stream().map(expense -> modelMapper.map(expense,ExpenseDTO.class)).toList();
        return expenseDTOList;
    }

    @Override
    public ExpenseDTO getExpenseById(Integer id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Expense","Id",id));

        return modelMapper.map(expense,ExpenseDTO.class);
    }

    @Override
    public ExpenseDTO updateExpense(Integer expId, ExpenseDTO expenseDTO) {
        Expense expense = expenseRepository.findById(expId).orElseThrow(()->new ResourceNotFoundException("Expense","Id",expId));

        expense.setTitle(expenseDTO.getTitle());
        expense.setCategory(expenseDTO.getCategory());
        expense.setAmount(expenseDTO.getAmount());
        expense.setDate(expenseDTO.getDate());
        expense.setDescription(expenseDTO.getDescription());

        Expense updatedExpense = expenseRepository.save(expense);
        return modelMapper.map(updatedExpense,ExpenseDTO.class);
    }

    @Override
    public void deleteExpense(Integer expId) {
        Expense expense = expenseRepository.findById(expId).orElseThrow(()->new ResourceNotFoundException("Expense","Id",expId));
        expenseRepository.delete(expense);
    }


}
