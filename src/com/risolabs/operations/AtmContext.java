package com.risolabs.operations;

import com.risolabs.domain.Transaction;
import com.risolabs.exception.AtmException;
import com.risolabs.exception.TransferException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by @mriso_dev on 24/08/17
 */
public class AtmContext {

    private AccountService accountService;
    private MoneySupplier moneySupplier;
    private Integer userMoney;
    private Integer userOption;
    private Scanner scan = new Scanner(System.in);
    private boolean session  = true;
    private boolean logged   = false;
    private TransactionService transactionService = new TransactionService();

    public AtmContext() throws AtmException {
        accountService = new AccountService();
        moneySupplier = new MoneySupplier();
    }

    public void TransferIntoAccount(final String accountNumber, BigDecimal value) throws AtmException {
        if(accountService.TransferIntoAccount(accountNumber, value)) {
            LocalDateTime dateTime = LocalDateTime.now();

            Transaction transactionDestiny = new Transaction(4, dateTime, value, accountNumber);
            addTransaction(transactionDestiny);

            Transaction transaction = new Transaction(4, dateTime, value, accountService.getAccountNumber());
            addTransaction(transaction);
        }else{
            throw new TransferException();
        }
    }

    public void addTransaction (Transaction transaction) {
        transactionService.addToList(transaction);
    }

    public List<Transaction> getTransactionList () {
        String accountNumber = accountService.getAccountNumber();
        String compare;
        List<Transaction> transactions =  transactionService.getListOfTransactions();
        List<Transaction> filtered = new ArrayList<>();
        for(Transaction atm : transactions) {
            compare = atm.getAccountNumber().trim();
            if(accountNumber.contentEquals(compare)) {
                filtered.add(atm);
            }
        }
        return filtered;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public boolean isSession() {
        return session;
    }

    public void setSession(boolean session) {
        this.session = session;
    }

    public Integer scanNextInteger () {
        return scan.nextInt();
    }

    public String scanNext() {
        return scan.next();
    }

    public void setUserMoney(Integer userMoney) {
        this.userMoney = userMoney;
    }

    public Integer getUserMoney() {
         return userMoney;
    }

    public Integer getUserOption() {
        return userOption;
    }

    public void setUserOption(Integer userOption) {
        this.userOption = userOption;
    }

    public boolean verifyAccount(String accountNumber) throws AtmException {
        return accountService.verifyAccount(accountNumber);
    }

    public String MoneyAvailableStatement() {
        return moneySupplier.MoneyAvailableStatement();
    }

    public BigDecimal getAccountBalance() {
        return accountService.getAccountBalance();
    }

    public int[] RequestCashNotes() throws AtmException {
        return moneySupplier.withDrawCash(userMoney);
    }

    public void DebitFromAccount() throws AtmException {
        LocalDateTime dateTime = LocalDateTime.now();
        Transaction transaction = new Transaction(2, dateTime, BigDecimal.valueOf(userMoney), accountService.getAccountNumber());
        addTransaction(transaction);
        accountService.withDrawCash(userMoney);
    }

    public int[] InsertCashNotes() throws AtmException {
        return moneySupplier.DepositCash(userMoney);
    }

    public void DepositIntoAccount() {
        LocalDateTime dateTime = LocalDateTime.now();
        Transaction transaction = new Transaction(3, dateTime, BigDecimal.valueOf(userMoney), accountService.getAccountNumber());
        addTransaction(transaction);
        accountService.Deposit(userMoney);
    }

}
