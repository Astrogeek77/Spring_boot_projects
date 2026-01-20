package com.gautam.sentinel.service;

import com.gautam.sentinel.handler.*;
import com.gautam.sentinel.model.Transaction;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class TransactionService {

    private final SanityCheckHandler sanityCheck;
    private final BlacklistHandler blacklistCheck;
    private final LargeTransactionHandler largeTransactionCheck;

    // The head of the chain
    private RiskHandler riskChain;

    public TransactionService(SanityCheckHandler sanityCheck,
                              BlacklistHandler blacklistCheck,
                              LargeTransactionHandler largeTransactionCheck) {
        this.sanityCheck = sanityCheck;
        this.blacklistCheck = blacklistCheck;
        this.largeTransactionCheck = largeTransactionCheck;
    }

    @PostConstruct
    public void initChain() {
        // Construct the chain: Sanity -> Blacklist -> Limit
        // This determines the ORDER of execution.
        this.riskChain = sanityCheck;
        sanityCheck.linkWith(blacklistCheck)
                .linkWith(largeTransactionCheck);
    }

    public String processTransaction(Transaction transaction) {
        // We only talk to the "Head" of the chain. We don't care what happens after.
        boolean approved = riskChain.check(transaction);

        if (approved) {
            return "Transaction Approved!";
        } else {
            return "Transaction Rejected. Check logs for reason.";
        }
    }
}
