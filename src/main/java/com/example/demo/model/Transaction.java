package com.example.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Transaction {
    @NotNull(message = "Transaction value cannot be null!!!")
    @Min(1)
    private Double value;

    @NotNull(message = "Transaction description cannot be null!!!")
    private String description;

    @NotNull(message = "Transaction category cannot be null!!!")
    private String category;

    public Transaction(Double value, String description, String category) {
        this.value = value;
        this.description = description;
        this.category = category;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "value=" + value +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
