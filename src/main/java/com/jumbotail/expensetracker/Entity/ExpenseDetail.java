package com.jumbotail.expensetracker.Entity;


import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class ExpenseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String userId;

    private String reasonForExpense;
    private LocalDate expenseDate;
    private String place;
    private String modeOfPayment;
}
