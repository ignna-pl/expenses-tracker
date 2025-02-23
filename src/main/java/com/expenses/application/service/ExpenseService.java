package com.expenses.application.service;

import com.expenses.application.model.Expense;
import com.expenses.application.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAll(){
        return expenseRepository.findAll();
    }

    public Expense save(Expense newExpense){
        return expenseRepository.save(newExpense);
    }

    public void delete(Long id){
        expenseRepository.deleteById(id);
    }

}
