/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

// Import necessary libraries for testing and mocking
package cc.tkmr.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

// Use MockitoExtension for running the tests with Mockito support
@ExtendWith(MockitoExtension.class)
public class AccountTest {

    // Create a spy of the Account object with an initial balance of 1000.00
    @Spy
    private Account account = new Account(new BigDecimal("1000.00"));

    // Test method to validate the call order of methods on the Account object
    @Test
    void validateCallOrder() {

        // Perform an action on the account object by paying a bill
        account.payBill(new BigDecimal("300.00"));

        // Verify that specific methods are called on the account object in a particular order
        InOrder inOrder = Mockito.inOrder(account);
        inOrder.verify(account).payBill(new BigDecimal("300.00"));
//        inOrder.verify(account).payBill(ArgumentMatchers.any(BigDecimal.class)); // argument matcher variation. Any BigDecimal is accepted. In this case it is not worth using it.
        inOrder.verify(account).validateBalance(new BigDecimal("300.00"));
        inOrder.verify(account).debitAmount(new BigDecimal("300.00"));
        inOrder.verify(account).sendCreditToIssuer(new BigDecimal("300.00"));
    }

    // Test method to validate the quantity of calls to the validateBalance method
    @Test
    void validateCallQuantity() {

        // Call the validateBalance method with different amounts
        account.validateBalance(new BigDecimal("300.00"));
        account.validateBalance(new BigDecimal("500"));
        account.validateBalance(new BigDecimal("1000.00"));

        // Verify that the validateBalance method is called exactly 3 times with any BigDecimal argument
        Mockito.verify(account, Mockito.times(3)).validateBalance(ArgumentMatchers.any(BigDecimal.class));
    }

    // Test method to return true when any amount is passed to the validateBalance method
    @Test
    void returnTrueToAnyAmountAtBalanceValidation() {

        // Mock the behavior of the validateBalance method to do nothing when called with any BigDecimal
        Mockito.doNothing().when(account).validateBalance(ArgumentMatchers.any(BigDecimal.class));

        // Call the validateBalance method with an amount of 3500.00
        account.validateBalance(new BigDecimal("3500.00"));
    }
}