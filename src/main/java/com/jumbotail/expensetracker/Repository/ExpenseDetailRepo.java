package com.jumbotail.expensetracker.Repository;

import com.jumbotail.expensetracker.Entity.ExpenseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseDetailRepo extends JpaRepository<ExpenseDetail, Integer> {

    List<ExpenseDetail> findAllByUserId(String userId);
}
