package com.expenses.application.controller;


import com.expenses.application.model.Income;
import com.expenses.application.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public List<Income> getAll(){
        return incomeService.getAll();
    }

    @PostMapping
    public Income save(@RequestBody Income newIncome){
        return  incomeService.save(newIncome);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        incomeService.delete(id);
    }


}
