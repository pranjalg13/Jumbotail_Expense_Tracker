package com.jumbotail.expensetracker.Repository;

import com.jumbotail.expensetracker.Entity.DueAmountDetail;
import com.jumbotail.expensetracker.Entity.ExpenseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DueAmountRepo extends JpaRepository<DueAmountDetail, Integer> {
    List<DueAmountDetail> findAllByUserId(String userId);
    DueAmountDetail findTopByUserId(String userId);
    @Query(value = "SELECT u from DueAmountDetail u WHERE u.userId=:userId")
    DueAmountDetail findTopByOrderByRepaymentDateDesc(@Param("userId") String userId);
}
