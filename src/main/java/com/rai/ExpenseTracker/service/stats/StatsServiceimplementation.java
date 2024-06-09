package com.rai.ExpenseTracker.service.stats;

import com.rai.ExpenseTracker.model.Expense;
import com.rai.ExpenseTracker.model.Income;
import com.rai.ExpenseTracker.payloads.GraphDTO;
import com.rai.ExpenseTracker.payloads.IncomeDTO;
import com.rai.ExpenseTracker.payloads.StatsDTO;
import com.rai.ExpenseTracker.repository.ExpenseRepository;
import com.rai.ExpenseTracker.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class StatsServiceimplementation implements StatsService {

    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private ExpenseRepository expenseRepository;


    public GraphDTO getChartData(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate,endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate,endDate));

        return graphDTO;
    }


    public StatsDTO getStats(){
        Double totalIncome = incomeRepository.sumAllAmount();
        Double totalExpense = expenseRepository.sumAllAmount();
        Optional<Income> income = incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> expense = expenseRepository.findFirstByOrderByDateDesc();

        StatsDTO statsDTO = new StatsDTO();
        statsDTO.setExpense(totalExpense);
        statsDTO.setIncome(totalIncome);

        if(income.isPresent()){
            statsDTO.setLatestIncome(income.get());
        }
        if(expense.isPresent()){
            statsDTO.setLatestExpense(expense.get());
        }



        statsDTO.setBalance(totalIncome-totalExpense);
        List<Income> incomeList = incomeRepository.findAll();
        List<Expense> expenseList = expenseRepository.findAll();

        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();

        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();

        statsDTO.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble() : null);
        statsDTO.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble() : null);
        statsDTO.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : null);
        statsDTO.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : null);

        return statsDTO;

    }
}
