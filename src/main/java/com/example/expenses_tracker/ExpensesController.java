package com.example.expenses_tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

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

}
