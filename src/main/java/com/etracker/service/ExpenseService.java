package com.etracker.service;

import com.etracker.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    List<Expense> findByUserId(Long userId);

    Expense saveTransaction(Expense transaction);

    Expense findById(Long id);

    void deleteById(Long id);
}
