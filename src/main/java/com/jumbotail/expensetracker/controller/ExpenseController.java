//package com.jumbotail.expensetracker.controller;
//
//import com.jumbotail.expensetracker.Service.ExpenseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/")
//public class ExpenseController {
//
//    @Autowired
//    private ExpenseService expenseService;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public  ResponseEntity<String> addUser(@RequestParam String email){
//        expenseService.createUser(email);
//        return new ResponseEntity<>("Success", HttpStatus.OK);
//
//    }
//
//}
