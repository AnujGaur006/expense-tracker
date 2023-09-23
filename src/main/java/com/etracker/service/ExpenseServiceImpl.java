package com.etracker.service;

import com.etracker.model.Expense;
import com.etracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    @Override
    public Expense saveTransaction(Expense transaction) {

        try {
            return expenseRepository.save(transaction);
        } catch (Exception e) {
            throw new RuntimeException("Invalid input" + e.getMessage());
        }
    }

    @Override
    public Expense findById(Long id) {
        Optional<Expense> result = expenseRepository.findById(id);

        Expense expenseObj = null;
        if(result.isPresent()){
            expenseObj = result.get();
        }else throw new RuntimeException("Did not find Exception id - " + id);

        return expenseObj;
    }

    @Override
    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }
}
