package com.expenses.application.controller;

import com.expenses.application.model.Expense;
import com.expenses.application.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAll(){
        return expenseService.getAll();
    }

    @PostMapping
    public Expense save(@RequestBody Expense newExpense){
        return expenseService.save(newExpense);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        expenseService.delete(id);
    }

}
