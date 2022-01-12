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
    @Query(value = "SELECT * from due_amount_detail u WHERE u.user_id=:userId order by repayment_date desc LIMIT 1", nativeQuery = true)
    DueAmountDetail findFirstOrderDate(@Param("userId") String userId);
}
