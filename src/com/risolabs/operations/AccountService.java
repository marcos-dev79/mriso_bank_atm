package com.risolabs.operations;

import com.risolabs.domain.Account;
import com.risolabs.exception.AccountWithoutFundsException;
import com.risolabs.exception.AtmException;
import com.risolabs.exception.AccountNotFoundException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by @mriso_dev on 24/08/17
 * This Class Initializes the Sample Accounts
 * Could be refactored to call a service to a Mainframe
 */
public class AccountService {

    private final Map<String, Account> accounts = new HashMap<>();
    private Account account;
    private int loginChances;
    private boolean loggedIn;

    public AccountService() {

        Account acc1 = new Account("João da Silva", new BigDecimal(10854.78), "54125-9");
        Account acc2 = new Account("Pedro Otávio Magalhães", new BigDecimal(1050.99), "25214-8");
        Account acc3 = new Account("Maria Green", new BigDecimal(7696), "88452-1");
        Account acc4 = new Account("Stephan Pereira", new BigDecimal(412.13), "15935-7");

        accounts.put(acc1.getAccountNumber(), acc1);
        accounts.put(acc2.getAccountNumber(), acc2);
        accounts.put(acc3.getAccountNumber(), acc3);
        accounts.put(acc4.getAccountNumber(), acc4);

        account = null;
        loginChances = 3;
        loggedIn = false;

    }

    public void TransferIntoAccount(final String accountNumber, BigDecimal value) throws AtmException {

        try {
            BigDecimal myval = account.getBalance();

            if(myval.compareTo(value) <= 0) {
                throw new AccountWithoutFundsException();
            }

            Account into_account = accounts.get(accountNumber.trim());

            if (into_account != null) {

                account.withDrawFromBalance(value);
                into_account.DepositToBalance(value);
                System.out.println("\nMoney transfered successfully.\n");

            } else {
                throw new AccountNotFoundException();
            }

        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean verifyAccount(final String accountNumber) throws AccountNotFoundException {

        if(loginChances > 1) {

            account = accounts.get(accountNumber.trim());

            if (account != null) {
                loggedIn = true;
                System.out.println("\nWelcome " + account.getUsername() + "!  \n");
            } else {
                loginChances--;
                loggedIn = false;
                System.out.println("\nAccount not found. Try Again ("+ Integer.toString(loginChances) +") \n");
            }

            return loggedIn;

        } else {
            throw new AccountNotFoundException();
        }

    }

    public BigDecimal getAccountBalance() {
        return account.getBalance();
    }

    public void withDrawCash(Integer moneyRequired) throws AtmException {
        BigDecimal cash = new BigDecimal(moneyRequired);
        account.withDrawFromBalance(cash);
    }

    public void Deposit(Integer moneyDeposited) {
        BigDecimal cash = new BigDecimal(moneyDeposited);
        account.DepositToBalance(cash);
    }


}
