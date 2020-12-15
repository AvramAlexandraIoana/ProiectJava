package com.example.demo.service;

import com.example.demo.model.Transaction;
import com.example.demo.repository.MainRepository;
import com.example.demo.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainService {

    @Autowired
    private MainRepository mainRepository;

    public List<Transaction> getTransactionList() {
        return mainRepository.getTransactionList();
    }

    public Transaction getTransactionByDescription(String description) {
        return  mainRepository.getTransactionByDescription(description);
    }

    public Transaction getTransactionByCategory(String category) {
        return  mainRepository.getTransactionByCategory(category);
    }

    public Transaction getTransactionByValue(Double value) {
       return mainRepository.getTransactionByValue(value);
    }

    public List<Transaction> getAllTransactionByCategory(String category) {
        return mainRepository.getAllTransactionByCategory(category);
    }

    public Transaction addTransaction(Transaction transaction) {
        return mainRepository.addTransaction(transaction);
    }
}
