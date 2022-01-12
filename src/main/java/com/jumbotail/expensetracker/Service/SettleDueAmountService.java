package com.jumbotail.expensetracker.Service;

import com.jumbotail.expensetracker.Entity.DueAmountDetail;
import com.jumbotail.expensetracker.Repository.DueAmountRepo;
import com.jumbotail.expensetracker.dtos.SettleAmountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static java.lang.Math.abs;

@Service
@Slf4j
public class SettleDueAmountService {


    @Autowired
    private UserService userService;

    @Autowired
    private DueAmountRepo dueAmountRepo;

    @Autowired
    private DueAmountDetailService dueAmountDetailService;

    @Autowired
    private ExpenseService expenseService;

    public ResponseEntity<String> settleUserAmount(String userEmail, Integer methodBit, SettleAmountDTO settleAmountDTO){
        if(methodBit == 0){
            //First In First Out
            DueAmountDetail firstDueUser = dueAmountRepo.findTopByUserId(userEmail);
            log.info("Element is" + firstDueUser);
            if(firstDueUser!=null){
                double remainingAmount = firstDueUser.getAmount() - settleAmountDTO.getAmount();
                if(remainingAmount <= 0){
                    dueAmountRepo.delete(firstDueUser);
                }
                else{
                    firstDueUser.setAmount(remainingAmount);
                    dueAmountRepo.save(firstDueUser);
                }
                return new ResponseEntity<>("Success",HttpStatus.OK);
             }
        }
        else if(methodBit == 1){
            // Last Repayment Date First
            DueAmountDetail firstDueUser = dueAmountRepo.findTopByOrderByRepaymentDateDesc(userEmail);
            if(firstDueUser!=null) {
                double remainingAmount = firstDueUser.getAmount() - settleAmountDTO.getAmount();
                if (remainingAmount <= 0) {
                    dueAmountRepo.delete(firstDueUser);
                } else {
                    firstDueUser.setAmount(remainingAmount);
                    dueAmountRepo.save(firstDueUser);
                }
                return new ResponseEntity<>("Success", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
    }
}
