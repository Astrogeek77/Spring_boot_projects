package com.gautam.sentinel.handler;

import com.gautam.sentinel.model.Transaction;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class SanityCheckHandler extends RiskHandler {
    @Override
    protected boolean doCheck(Transaction transaction) {
        if (transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Validation Failed: Amount must be positive.");
            return false;
        }
        System.out.println("Sanity Check Passed");
        return true;
    }
}
