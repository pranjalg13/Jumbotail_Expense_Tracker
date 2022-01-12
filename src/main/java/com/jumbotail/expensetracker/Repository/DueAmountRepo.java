package com.jumbotail.expensetracker.Repository;

import com.jumbotail.expensetracker.Entity.DueAmountDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DueAmountRepo extends JpaRepository<DueAmountDetail, Integer> {

}
