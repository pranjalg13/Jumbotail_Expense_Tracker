package com.jumbotail.expensetracker.controller;

import com.jumbotail.expensetracker.Entity.DueAmountDetail;
import com.jumbotail.expensetracker.Entity.ExpenseDetail;
import com.jumbotail.expensetracker.Service.DueAmountDetailService;
import com.jumbotail.expensetracker.Service.ExpenseService;
import com.jumbotail.expensetracker.Service.SettleDueAmountService;
import com.jumbotail.expensetracker.dtos.DueAmountDTO;
import com.jumbotail.expensetracker.dtos.ExpenseDTO;
import com.jumbotail.expensetracker.dtos.SettleAmountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ExpenseTrackerController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private DueAmountDetailService dueAmountDetailService;

    @Autowired
    private SettleDueAmountService settleDueAmountService;

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

    @RequestMapping(method = RequestMethod.POST , value = "/pay_due_amount/{userEmail}/{method}")
    public ResponseEntity<String> settleDueAmountUser(@PathVariable String userEmail, @PathVariable Integer method , @RequestBody SettleAmountDTO settleAmountDTO){
        return settleDueAmountService.settleUserAmount(userEmail, method, settleAmountDTO);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get_all_expense/{userEmail}")
    public List<ExpenseDetail> getAllExpenseOfAUser(@PathVariable String userEmail){
        return expenseService.getAllExpenseOfAUser(userEmail);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get_all_due_amount_of_user/{userEmail}")
    public List<DueAmountDetail> getAllDueAmountDetailOfUser(@PathVariable String userEmail){
        return dueAmountDetailService.getAllDueAmountDetailOfUser(userEmail);
    }

}
