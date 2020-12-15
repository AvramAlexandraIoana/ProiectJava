package com.example.demo.controller;


import com.example.demo.model.Transaction;
import com.example.demo.service.MainService;
import com.example.demo.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/get")
    public List<Transaction> getTransactionList() {
        return mainService.getTransactionList();
    }

    @GetMapping("/byDescription")
    public ResponseEntity<?> getTransactionByDescription(@RequestParam String description) {
//        try {
        return  ResponseEntity.ok().body(mainService.getTransactionByDescription(description));
//        } catch (ObjectNotFoundException exception) {
//            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(exception.getMessage());
//        }
    }

    @GetMapping("/byCategory")
    public ResponseEntity <?> getTransactionByCategory(@RequestParam String category) {
//        try {
        return  ResponseEntity.ok().body(mainService.getTransactionByCategory(category));
//        } catch (ObjectNotFoundException exception) {
//            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(exception.getMessage());
//        }
    }

    @GetMapping("/byValue")
    public ResponseEntity<?> getTransactionByValue(@RequestParam  Double value) {
//        try {
        return  ResponseEntity.ok().body(mainService.getTransactionByValue(value));
//        } catch (ObjectNotFoundException exception) {
//            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(exception.getMessage());
//        }
    }

    @GetMapping("/allByCategory")
    public List<Transaction> getAllTransactionByCategory(String category) {
        return mainService.getAllTransactionByCategory(category);
    }

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody @Valid Transaction transaction) {
        return mainService.addTransaction(transaction);
    }
}
