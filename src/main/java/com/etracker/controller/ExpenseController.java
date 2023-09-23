package com.etracker.controller;

import com.etracker.model.Expense;
import com.etracker.model.User;
import com.etracker.service.ExpenseService;
import com.etracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    UserService userService;

    @GetMapping("/expenses/expenses-list")
    public String viewExpenses(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        User user = userService.findUserByEmail(email);
        Long userId = user.getId();
        List<Expense> expenses = expenseService.findByUserId(userId);

        // add to the spring model
        model.addAttribute("userId",userId);
        model.addAttribute("expenses", expenses);
       return "Expenses";
    }

    @GetMapping("/expenses/add-expense")
    public String showFormForAdd(Model model) {
        Expense expense = new Expense();

        model.addAttribute("expense",expense);
        return "ExpenseForm";
    }

    @PostMapping("/expenses/save")
    public String saveExpense(@ModelAttribute("expense") Expense expense){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();
        User user = userService.findUserByEmail(email);
        expense.setUser(user);

        expenseService.saveTransaction(expense);

        return "redirect:/api/expenses/expenses-list";
    }

    @GetMapping("expenses/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("expenseId") Long theId,Model theModel){
        //get the employee from the service
        Expense expenseObj = expenseService.findById(theId);

        //set the employee in the model to repopulate the form
        theModel.addAttribute("expense",expenseObj);

        //send over to our form
        return "ExpenseForm";
    }

    @GetMapping("expenses/delete")
    public String delete(@RequestParam("expenseId") Long id){
        //get the employee from the service
        expenseService.deleteById(id);

        return "redirect:/api/expenses/expenses-list";

    }

}
