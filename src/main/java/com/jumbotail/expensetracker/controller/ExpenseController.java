package com.jumbotail.expensetracker.controller;

import com.jumbotail.expensetracker.Service.DueAmountDetailService;
import com.jumbotail.expensetracker.Service.ExpenseService;
import com.jumbotail.expensetracker.dtos.DueAmountDTO;
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

    @Autowired
    private DueAmountDetailService dueAmountDetailService;

    @RequestMapping(method = RequestMethod.POST, value = "/create_user")
    public  ResponseEntity<String> addUser(@RequestBody String email){
        expenseService.createUser(email);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add_user_expense")
    public ResponseEntity<String> addUserExpense(@RequestParam String userEmail, @RequestBody ExpenseDTO expenseDTO){
        return expenseService.addUserExpense(userEmail, expenseDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add_due_amount_data")
    public ResponseEntity<String> addDueAmountData(@RequestParam String userEmail, @RequestBody DueAmountDTO dueAmountDTO){
        return dueAmountDetailService.addDueAmountData(userEmail, dueAmountDTO);
    }

}
