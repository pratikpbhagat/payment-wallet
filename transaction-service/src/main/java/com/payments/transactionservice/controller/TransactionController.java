package com.payments.transactionservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @GetMapping("/get")
    public ResponseEntity<String> getTransactions() {
        return ResponseEntity.status(200).body("Transactions");
    }
}
