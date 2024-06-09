package com.rai.ExpenseTracker.service.income;

import com.rai.ExpenseTracker.payloads.IncomeDTO;

import java.util.List;

public interface IncomeService {

    // Creating Income
    IncomeDTO saveIncome(IncomeDTO incomeDTO);

    // Updating Income
    IncomeDTO updateIncome(Integer incomeId, IncomeDTO incomeDTO);

    // Deleting Income
    void deleteIncome(Integer incomeId);

    // Getting All Income
    List<IncomeDTO> getAllIncome();

    // Getting Income By Id
    IncomeDTO getIncomeById(Integer incomeId);

}
