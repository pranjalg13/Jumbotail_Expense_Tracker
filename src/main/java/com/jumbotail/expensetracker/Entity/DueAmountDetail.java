package com.jumbotail.expensetracker.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class DueAmountDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String userId;

    private String payDuePerson; //person whose money need to be paid is identified using email

    private Double amount;
    private LocalDate repaymentDate;
}
