package com.gautam.sentinel.handler;

import com.gautam.sentinel.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class BlacklistHandler extends RiskHandler {
    @Override
    protected boolean doCheck(Transaction transaction) {
        if ("BANNED_USER".equals(transaction.getAccountId())) {
            System.out.println("Validation Failed: Account is blacklisted.");
            return false;
        }
        System.out.println("Blacklist Check Passed");
        return true;
    }
}
