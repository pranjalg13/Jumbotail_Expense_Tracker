package com.jumbotail.expensetracker.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class User {

    @Id
    private String email;

}
