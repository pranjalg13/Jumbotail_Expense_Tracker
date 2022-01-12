package com.jumbotail.expensetracker.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DueAmountDTO {
    private String person; //person is identified using email
    private Double amount;
    private LocalDate repaymentDate;
}
