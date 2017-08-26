package com.risolabs.operations;

import com.risolabs.domain.Transaction;
import com.risolabs.exception.AtmException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class AccountWithdrawOperation extends AbstractAtmOperations implements Operations {

    public AccountWithdrawOperation(AtmContext atmContext) {
        super(atmContext);
    }

    private void withdrawCash() throws AtmException {
        try {
            LocalDateTime dateTime = LocalDateTime.now();
            Transaction transaction = new Transaction(2, dateTime, BigDecimal.valueOf(atmContext.getUserMoney()));
            atmContext.addTransaction(transaction);

            int[] cash;
            cash = atmContext.RequestCashNotes();
            atmContext.DebitFromAccount();
            System.out.println("Take your notes: HUNDRED(" + cash[0] + ") FIFTY(" + cash[1] + ") TWENTY(" + cash[2] + ") TEN(" + cash[3] + ")");
        } catch(AtmException e) {
            System.out.println(e.getMessage());
        }
    }

    public void execute() throws AtmException {
        try {
            System.out.println("\nPlease inform amount to withdraw:");
            atmContext.setUserMoney(atmContext.scanNextInteger());
            this.withdrawCash();
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
    }
}
