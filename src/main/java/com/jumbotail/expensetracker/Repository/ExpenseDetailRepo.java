package com.jumbotail.expensetracker.Repository;

import com.jumbotail.expensetracker.Entity.ExpenseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseDetailRepo extends JpaRepository<ExpenseDetail, Integer> {
}
