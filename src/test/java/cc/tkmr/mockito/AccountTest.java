/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    // Mock the Account object
    @Spy
    private Account account = new Account(new BigDecimal("1000.00"));

    // Validate call order
    @Test
    void validateCallOrder() {

        account.payBill(new BigDecimal("300.00"));

        // Verify that validateBalance is called in order
        InOrder inOrder = Mockito.inOrder(account);
        inOrder.verify(account).payBill(new BigDecimal("300.00"));
//        inOrder.verify(account).payBill(ArgumentMatchers.any(BigDecimal.class));  // argument matcher variation. Any BigDecimal is accepted. In this case it is not worth using it.
        inOrder.verify(account).validateBalance(new BigDecimal("300.00"));
        inOrder.verify(account).debitAmount(new BigDecimal("300.00"));
        inOrder.verify(account).sendCreditToIssuer(new BigDecimal("300.00"));
    }

    // Validate call quantity
    @Test
    void validateCallQuantity() {

        account.validateBalance(new BigDecimal("300.00"));
        account.validateBalance(new BigDecimal("500"));
        account.validateBalance(new BigDecimal("1000.00"));

        // Verify that validateBalance is called exactly 3 times
        Mockito.verify(account,Mockito.times(3)).validateBalance(ArgumentMatchers.any(BigDecimal.class));
    }
}
