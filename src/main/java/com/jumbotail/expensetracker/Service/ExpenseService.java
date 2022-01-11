package com.jumbotail.expensetracker.Service;

import com.jumbotail.expensetracker.Entity.ExpenseDetail;
import com.jumbotail.expensetracker.Entity.User;
import com.jumbotail.expensetracker.Repository.ExpenseDetailRepo;
import com.jumbotail.expensetracker.Repository.UserRepo;
import com.jumbotail.expensetracker.dtos.ExpenseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class ExpenseService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ExpenseDetailRepo expenseDetailRepo;

    public void createUser(String email) {
        User user = new User();
        user.setEmail(email);
        userRepo.save(user);
    }

    public void addUserExpense(String userEmail, ExpenseDTO expenseDTO) {
        try{
            Optional<User> userId = userRepo.findById(userEmail);
            userId.get();
            ExpenseDetail expenseDetail = new ExpenseDetail();
            expenseDetail.setUserId(userId.get().getEmail());
            expenseDetail.setExpenseDate(LocalDate.now());
            expenseDetail.setReasonForExpense(expenseDTO.getReasonForExpense());
            expenseDetail.setPlace(expenseDTO.getPlace());
            expenseDetail.setModeOfPayment(expenseDTO.getModeOfPayment());
            expenseDetailRepo.save(expenseDetail);

        }catch (Exception e){
            log.error("I am handling" + e.getMessage());
        }

    }

}
