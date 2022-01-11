package com.jumbotail.expensetracker.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDTO {
    private String reasonForExpense;
    private String place;
    private String modeOfPayment;
}
