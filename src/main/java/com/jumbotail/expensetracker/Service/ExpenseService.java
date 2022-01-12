package com.jumbotail.expensetracker.Service;

import com.jumbotail.expensetracker.Entity.ExpenseDetail;
import com.jumbotail.expensetracker.Entity.User;
import com.jumbotail.expensetracker.Repository.ExpenseDetailRepo;
import com.jumbotail.expensetracker.Repository.UserRepo;
import com.jumbotail.expensetracker.dtos.ExpenseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ExpenseService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ExpenseDetailRepo expenseDetailRepo;

    @Autowired
    private UserService userService;

    public void createUser(String email) {
        User user = new User();
        user.setEmail(email);
        userRepo.save(user);
        log.info("User Created Successfully " + email);
    }

    public ResponseEntity<String> addUserExpense(String userEmail, ExpenseDTO expenseDTO) {
        try{
            User user = userService.getUserById(userEmail);
            ExpenseDetail expenseDetail = new ExpenseDetail();
            expenseDetail.setUserId(user.getEmail());
            expenseDetail.setExpenseDate(LocalDate.now());
            expenseDetail.setReasonForExpense(expenseDTO.getReasonForExpense());
            expenseDetail.setPlace(expenseDTO.getPlace());
            expenseDetail.setModeOfPayment(expenseDTO.getModeOfPayment());
            expenseDetailRepo.save(expenseDetail);
            log.info("Successfully Added the Expense for User "+ userEmail);

        }catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>("User Not Found " + userEmail ,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public List<ExpenseDetail> getAllExpenseOfAUser(String userEmail) {
        return expenseDetailRepo.findAllByUserId(userEmail);
    }
}
