package com.gautam.sentinel.controller;

import com.gautam.sentinel.model.Transaction;
import com.gautam.sentinel.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/pay")
    public String makePayment(@RequestParam String user, @RequestParam BigDecimal amount) {
        Transaction tx = new Transaction(user, amount, "US");
        return transactionService.processTransaction(tx);
    }
}
