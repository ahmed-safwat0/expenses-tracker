package com.example.expenses_tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.LinkedHashMap;


@RestController
public class ExpensesController {
    private LinkedHashMap<Integer, Expense> expenses;

    public ExpensesController() {
        this.expenses = new LinkedHashMap<>();
    }

    @GetMapping("/expenses")
    public ArrayList<Expense> getExpenses() {
        return new ArrayList<>(expenses.values());
    }
    @GetMapping("/expenses/total")
    public double getTotalExpenses() {
        return expenses.values().stream().mapToDouble(Expense::getAmount).sum();
    }
    

    @PostMapping("/expenses")
    public Expense addExpense(@RequestBody Expense expense) {
        expenses.put(expense.getId(), expense);
        return expense;
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable int id) {
        expenses.remove(id);
    }
}
