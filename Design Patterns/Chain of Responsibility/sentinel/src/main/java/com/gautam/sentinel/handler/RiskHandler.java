package com.gautam.sentinel.handler;

import com.gautam   .sentinel.model.Transaction;

public abstract class RiskHandler {

    private RiskHandler nextHandler;

    // This method allows us to build the chain: A.link(B).link(C)
    public RiskHandler linkWith(RiskHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler; // Return the next handler to allow fluent chaining
    }

    // The method that triggers the flow
    public boolean check(Transaction transaction) {
        // 1. Do the check for THIS specific class
        if (!doCheck(transaction)) {
            return false; // If this step fails, stop the whole chain!
        }

        // 2. If this step passed, and there is a "next" step, pass the buck
        if (nextHandler != null) {
            return nextHandler.check(transaction);
        }

        // 3. If we are here, we are at the end of the chain, and everything passed.
        return true;
    }

    // The logic that each concrete class must implement
    protected abstract boolean doCheck(Transaction transaction);
}
