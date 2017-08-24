package com.risolabs.domain;

import java.math.BigDecimal;

/**
 * Created by @mriso_dev on 23/08/17
 * This class represents the user's account
 */
public class Account {

    private String username;
    private BigDecimal balance;
    private String accountNumber;

    public Account(String username, BigDecimal balance, String accountNumber) {
        this.username = username;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void withDrawFromBalance(BigDecimal withdraw) {
        this.balance = balance.subtract(withdraw);
    }

}
