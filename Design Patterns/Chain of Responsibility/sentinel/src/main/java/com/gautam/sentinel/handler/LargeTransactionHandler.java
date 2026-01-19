package com.gautam.sentinel.handler;

import com.gautam.sentinel.model.Transaction;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class LargeTransactionHandler extends RiskHandler {
    @Override
    protected boolean doCheck(Transaction transaction) {
        if (transaction.getAmount().compareTo(new BigDecimal("10000")) > 0) {
            System.out.println("Validation Failed: Amount too large for instant processing.");
            return false;
        }
        System.out.println("Limit Check Passed");
        return true;
    }
}
