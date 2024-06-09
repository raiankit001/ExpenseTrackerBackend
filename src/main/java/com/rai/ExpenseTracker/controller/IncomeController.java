package com.rai.ExpenseTracker.controller;

import com.rai.ExpenseTracker.payloads.IncomeDTO;
import com.rai.ExpenseTracker.service.income.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;


    // Creating Income
    @PostMapping("/")
    public ResponseEntity<IncomeDTO> saveIncome(@RequestBody IncomeDTO incomeDTO){
        IncomeDTO savedIncome = incomeService.saveIncome(incomeDTO);
        return new ResponseEntity<>(savedIncome, HttpStatus.CREATED);
    }

    // Updating Income
    @PutMapping("/{incomeId}")
    public ResponseEntity<IncomeDTO> updateIncome(@PathVariable("incomeId") Integer incomeId,@RequestBody IncomeDTO incomeDTO){
        IncomeDTO updatedIncome = incomeService.updateIncome(incomeId,incomeDTO);
        return new ResponseEntity<>(updatedIncome,HttpStatus.OK);
    }

    // Deleting Income
    @DeleteMapping("/{incomeId}")
    public ResponseEntity<?> deleteIncome(@PathVariable("incomeId") Integer incomeId){
        incomeService.deleteIncome(incomeId);
        return ResponseEntity.ok(null);
    }

    // Getting All Income
    @GetMapping("/")
    public ResponseEntity<List<IncomeDTO>> getAllIncome(){
        List<IncomeDTO> incomeDTOList = incomeService.getAllIncome();
        return new ResponseEntity<>(incomeDTOList,HttpStatus.OK);
    }

    // Getting Income By id
    @GetMapping("/{incomeId}")
    public ResponseEntity<IncomeDTO> getIncomeById(@PathVariable("incomeId") Integer incomeId){
        IncomeDTO incomeDTO = incomeService.getIncomeById(incomeId);
        return new ResponseEntity<>(incomeDTO,HttpStatus.OK);
    }



}
