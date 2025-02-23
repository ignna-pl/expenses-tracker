package com.expenses.application.service;

import com.expenses.application.model.Income;
import com.expenses.application.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> getAll(){
        return incomeRepository.findAll();
    }

    public Income save(Income newIncome){
        return incomeRepository.save(newIncome);
    }

    public void delete(Long id){
        incomeRepository.deleteById(id);
    }

}
