package com.jumbotail.expensetracker.Service;

import com.jumbotail.expensetracker.Entity.DueAmountDetail;
import com.jumbotail.expensetracker.Entity.User;
import com.jumbotail.expensetracker.Repository.DueAmountRepo;
import com.jumbotail.expensetracker.dtos.DueAmountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DueAmountDetailService {

    @Autowired
    private UserService userService;

    @Autowired
    private DueAmountRepo dueAmountRepo;

    public ResponseEntity<String> addDueAmountData(String userEmail, DueAmountDTO dueAmountDTO) {
        try {
            User user = userService.getUserById(userEmail);
            DueAmountDetail dueAmountDetail = new DueAmountDetail();
            dueAmountDetail.setAmount(dueAmountDTO.getAmount());
            dueAmountDetail.setUserId(user.getEmail());
            dueAmountDetail.setPayDuePerson(dueAmountDTO.getPayDuePerson());;
            dueAmountDetail.setRepaymentDate(dueAmountDTO.getRepaymentDate());
            dueAmountRepo.save(dueAmountDetail);
        }
        catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>("User Not Found" , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public List<DueAmountDetail> getAllDueAmountDetailOfUser(String userId){
        return dueAmountRepo.findAllByUserId(userId);
    }
}
