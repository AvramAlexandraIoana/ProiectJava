package com.example.demo.repository;

import com.example.demo.model.Transaction;
import com.example.demo.utils.ObjectNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MainRepository {
    private static List<Transaction> transactionList = new ArrayList<>();

    public MainRepository() {
        transactionList.add(new Transaction(23.0, "Test1", "Cumparaturi"));
        transactionList.add(new Transaction(20.2, "Test2", "Transfer"));
        transactionList.add(new Transaction(12.3, "Test3", "Telefonie"));


    }
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public Transaction getTransactionByDescription(String description) {
        return transactionList.stream()
                .filter(transaction -> transaction.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException("Transaction description doesn't exist!"));
    }

    public Transaction getTransactionByCategory(String category) {
        return transactionList.stream()
                .filter(transaction -> transaction.getCategory().equals(category))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException("Transaction category doesn't exist!"));
    }

    public List<Transaction> getAllTransactionByCategory(String category) {
        return transactionList.stream()
                .filter(transaction -> transaction.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public Transaction getTransactionByValue(Double value) {
        return transactionList.stream()
                .filter(transaction -> transaction.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException("Transaction value doesn't exist!"));
    }

    public Transaction addTransaction(Transaction transaction) {
        transactionList.add(transaction);
        return transaction;
    }


    }
