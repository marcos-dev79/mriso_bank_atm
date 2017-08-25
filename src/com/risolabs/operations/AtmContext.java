package com.risolabs.operations;

import com.risolabs.exception.AtmException;
import java.math.BigDecimal;
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
    boolean session  = true;

    public AtmContext() throws AtmException {
        accountService = new AccountService();
        moneySupplier = new MoneySupplier();
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
        accountService.withDrawCash(userMoney);
    }

    public int[] InsertCashNotes() throws AtmException {
        return moneySupplier.DepositCash(userMoney);
    }

    public void DepositIntoAccount() {
        accountService.Deposit(userMoney);
    }

}