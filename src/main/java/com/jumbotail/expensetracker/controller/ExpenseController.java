package com.jumbotail.expensetracker.controller;

import com.jumbotail.expensetracker.Service.ExpenseService;
import com.jumbotail.expensetracker.dtos.ExpenseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @RequestMapping(method = RequestMethod.GET, value = "/create_user")
    public  ResponseEntity<String> addUser(@RequestParam String email){
        expenseService.createUser(email);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add_user_expense")
    public ResponseEntity<String> addUserExpense(@RequestParam String userEmail, @RequestBody ExpenseDTO expenseDTO){
        expenseService.addUserExpense(userEmail,expenseDTO);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
