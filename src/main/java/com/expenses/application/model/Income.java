package com.expenses.application.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private LocalDate date;
    private String source;

    //Builders

    public Income(){}

    public Income(Double amount, LocalDate date, String source){
        this.amount = amount;
        this.date = date;
        this.source = source;
    }

    //Getters & Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
}
