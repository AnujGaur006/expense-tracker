package com.etracker.repository;

import com.etracker.model.Expense;
import com.etracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    public List<Expense> findByUserId(Long userId);

//    public Expense findByUserIdAndId(Long userId, Long transactionId);

}
