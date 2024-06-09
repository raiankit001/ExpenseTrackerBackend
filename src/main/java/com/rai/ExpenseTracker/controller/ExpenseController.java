package com.rai.ExpenseTracker.controller;

import com.rai.ExpenseTracker.payloads.ExpenseDTO;
import com.rai.ExpenseTracker.service.expense.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
//@CrossOrigin("*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;


    // Create Expense
    @PostMapping("/")
    public ResponseEntity<ExpenseDTO> saveExpense(@RequestBody ExpenseDTO expenseDTO){
        ExpenseDTO savedExpense = expenseService.saveExpense(expenseDTO);
        return new ResponseEntity<>(expenseDTO, HttpStatus.CREATED);
    }

    // Get All Expense

    @GetMapping("/")
    public ResponseEntity<List<ExpenseDTO>> getAllExpense(){
        List<ExpenseDTO> expenseDTOList = expenseService.getAllExpense();
        return new ResponseEntity<>(expenseDTOList,HttpStatus.OK);
    }

    // Get Expense By Id

    @GetMapping("/{expId}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable("expId") Integer id){
        ExpenseDTO expenseDTO = expenseService.getExpenseById(id);
        return new ResponseEntity<>(expenseDTO,HttpStatus.OK);
    }


    // Update Expense

    @PutMapping("/{expId}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable("expId") Integer expId,
                                                    @RequestBody ExpenseDTO expenseDTO){
        ExpenseDTO updatedExpense = expenseService.updateExpense(expId,expenseDTO);
        return new ResponseEntity<>(updatedExpense,HttpStatus.OK);
    }

    // Delete Expense

    @DeleteMapping("/{expId}")
    public ResponseEntity<?> deleteExpense(@PathVariable("expId") Integer expId){
        expenseService.deleteExpense(expId);
        return ResponseEntity.ok(null);
    }

}
