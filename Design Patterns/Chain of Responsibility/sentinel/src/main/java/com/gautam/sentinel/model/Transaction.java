package com.gautam.sentinel.model;

import java.math.BigDecimal;

public class Transaction {
    private String accountId;
    private BigDecimal amount;
    private String region;

    // Constructors, Getters, Setters
    public Transaction(String accountId, BigDecimal amount, String region) {
        this.accountId = accountId;
        this.amount = amount;
        this.region = region;
    }

    public String getAccountId() { return accountId; }
    public BigDecimal getAmount() { return amount; }
    public String getRegion() { return region; }
}
