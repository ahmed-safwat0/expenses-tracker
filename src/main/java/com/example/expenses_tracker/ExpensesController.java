package com.example.expenses_tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ExpensesController {
    private ArrayList<Expense> expenses;

    public ExpensesController() {
        this.expenses = new ArrayList<>();
        Expense e1 = new Expense("Groceries", 50.0, "2023-06-01", "Food", "Weekly grocery shopping");
        Expense e2 = new Expense("Movie Tickets", 30.0, "2023-06-02", "Entertainment",
                "Went to the movies with friends");
        this.expenses.add(e1);
        this.expenses.add(e2);
    }

    @GetMapping("/expenses")
    public ArrayList<Expense> getExpenses() {
        return expenses;
    }
    
    @PostMapping("/expenses")
    public Expense addExpense(@RequestBody Expense expense) {
        expenses.add(expense);
        return expense;
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable int id) {
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getId() == id) {
                expenses.remove(i);
                return;
            }
        }
    }
}
