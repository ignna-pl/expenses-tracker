package com.expenses.application.repository;

import com.expenses.application.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IncomeRepository extends JpaRepository<Income, Long>{

    @Query("SELECT SUM(inc.amount) FROM Income inc WHERE YEAR(inc.date) = :year AND MONTH(inc.date) = :month")
    Double sumAmountByDate(@Param("year") int year, @Param("month") int month);

}
