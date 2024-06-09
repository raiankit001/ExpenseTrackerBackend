package com.rai.ExpenseTracker.service.income;

import com.rai.ExpenseTracker.exceptions.ResourceNotFoundException;
import com.rai.ExpenseTracker.model.Income;
import com.rai.ExpenseTracker.payloads.IncomeDTO;
import com.rai.ExpenseTracker.repository.IncomeRepository;
import com.rai.ExpenseTracker.service.income.IncomeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImplementation implements IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private ModelMapper modelMapper;


    // Creating Income

    @Override
    public IncomeDTO saveIncome(IncomeDTO incomeDTO) {
        Income savedIncome = incomeRepository.save( modelMapper.map(incomeDTO,Income.class));
        return modelMapper.map(savedIncome,IncomeDTO.class);
    }

    // Updating Income

    @Override
    public IncomeDTO updateIncome(Integer incomeId, IncomeDTO incomeDTO) {
        Income income = incomeRepository.findById(incomeId).orElseThrow(()->new ResourceNotFoundException("Income","id",incomeId));
        income.setAmount(incomeDTO.getAmount());
        income.setTitle(incomeDTO.getTitle());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());
        income.setDate(incomeDTO.getDate());

        Income updatedIncome = incomeRepository.save(income);
        return modelMapper.map(updatedIncome,IncomeDTO.class);
    }

    // Deleting Income

    @Override
    public void deleteIncome(Integer incomeId) {
        Income income = incomeRepository.findById(incomeId).orElseThrow(()->new ResourceNotFoundException("Income","Id",incomeId));
        incomeRepository.delete(income);
    }

    // Getting All Income

    @Override
    public List<IncomeDTO> getAllIncome() {
        List<Income> incomeList = incomeRepository.findAll();
        List<IncomeDTO> incomeDTOList = incomeList.stream().map(income -> modelMapper.map(income,IncomeDTO.class)).toList();
        return incomeDTOList;
    }

    // Getting Income By Id

    @Override
    public IncomeDTO getIncomeById(Integer incomeId) {
        Income income = incomeRepository.findById(incomeId).orElseThrow(()->new ResourceNotFoundException("Income","Id",incomeId));

        return modelMapper.map(income,IncomeDTO.class);
    }

}
