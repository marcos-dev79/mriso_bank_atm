package com.risolabs.operations;

import com.risolabs.domain.Money;
import com.risolabs.exception.AbstractException;
import com.risolabs.exception.InvalidCashException;
import com.risolabs.exception.OutOfCashException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by @mriso_dev on 24/08/17
 */
public class AtmOperations {

    private AccountService accountService;
    private MoneySupplier moneySupplier;

    public AtmOperations() throws AbstractException {
        accountService = new AccountService();
        moneySupplier = new MoneySupplier();
    }

    public boolean verifyAccount(String accountNumber) throws AbstractException {
        return accountService.verifyAccount(accountNumber);
    }

    public String MoneyAvailableStatement() {
        return moneySupplier.MoneyAvailableStatement();
    }

    public void getAccountBalance() {
        BigDecimal accountBalance = accountService.getAccountBalance();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        String dateTime = LocalDateTime.now().format(formatter);
        System.out.println("\n");
        System.out.println("Your current net bank statement:");
        System.out.println(dateTime + " ... " + accountBalance.doubleValue());
        System.out.println("\n");
    }

    public void withDrawCash(Integer moneyRequired) throws AbstractException {

        try {
            int[] cash;
            cash = moneySupplier.withDrawCash(moneyRequired);
            Integer debit = (cash[0] * Money.HUNDRED.getValue()) +
                    (cash[1] * Money.FIFTY.getValue()) +
                    (cash[2] * Money.TWENTY.getValue()) +
                    (cash[3] * Money.TEN.getValue());

            accountService.withDrawCash(debit);

            System.out.println("Take your notes: HUNDRED(" + cash[0] + ") FIFTY(" + cash[1] + ") TWENTY(" + cash[2] + ") TEN(" + cash[3] + ")");
        } catch(AbstractException e) {
            System.out.println(e.getMessage());
        }
    }

    public void depositMoney(Integer moneyDeposited) throws AbstractException {
        try {
          int[] cash;
          cash = moneySupplier.DepositCash(moneyDeposited);
          accountService.Deposit(moneyDeposited);

            System.out.println("You deposited " + moneyDeposited + " with the following notes: HUNDRED(" + cash[0] + ") FIFTY(" + cash[1] + ") TWENTY(" + cash[2] + ") TEN(" + cash[3] + ")");

        } catch (AbstractException e) {
            System.out.println(e.getMessage());
        }
    }

}
