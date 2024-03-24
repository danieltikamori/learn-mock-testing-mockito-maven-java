/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance; // Or BigDecimal for money/currency

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public void payBill(BigDecimal payAmount) {
        validateBalance(payAmount);
        debitAmount(payAmount);
        sendCreditToIssuer(payAmount);
    }

    public void validateBalance(BigDecimal payAmount) {
        if (balance.compareTo(payAmount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }
    }

    public void debitAmount(BigDecimal payAmount) {
        this.balance = this.balance.subtract(payAmount);
    }

    public void sendCreditToIssuer(BigDecimal payAmount) {
        // Send credit to issuer
    }

}
