package com.expenses.application.service;

import com.expenses.application.repository.ExpenseRepository;
import com.expenses.application.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Balance {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public Double calculateMonthlyBalance(int year, int month){
        Double totalIncome = incomeRepository.sumAmountByDate(year, month);
        Double totalExpense = expenseRepository.sumAmountByDate(year, month);

        return (totalIncome != null ? totalIncome : 0) - (totalExpense != null? totalExpense : 0); //if totalIncome or totalExpense is null they are set to 0
    }

}
