package com.expenses.application.repository;

import com.expenses.application.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT SUM(exp.amount) FROM Expense exp WHERE YEAR(exp.date) = :year AND MONTH(exp.date) = :month")
    Double sumAmountByDate(@Param("year") int year, @Param("month") int month);

}
