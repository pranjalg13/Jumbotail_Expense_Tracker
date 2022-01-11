package com.jumbotail.expensetracker.Entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class ExpenseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String userEmail;

    private String reasonForExpense;
    private LocalDate expenseDate;
    private String place;
    private String modeOfPayment;
}
