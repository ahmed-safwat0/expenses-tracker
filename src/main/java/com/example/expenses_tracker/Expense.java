package com.example.expenses_tracker;

public class Expense {
    private String name;
    private double amount;
    private String date;
    private String category;
    private String description;
    private int id;
    private static int nextId = 0;

    public Expense(String name, double amount, String date, String category, String description) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.description = description;
        this.id = Expense.nextId++;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Expense{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description +
                '}';
    }
}
