package com.risolabs.operations;

import com.risolabs.domain.Transaction;
import com.risolabs.exception.AtmException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class AccountDepositer  extends AbstractAtmOperations implements Operations {

    public AccountDepositer(AtmContext atmContext) {
        super(atmContext);
    }

    public void depositMoney() throws AtmException {
        try {
            LocalDateTime dateTime = LocalDateTime.now();
            Transaction transaction = new Transaction(3, dateTime, BigDecimal.valueOf(atmContext.getUserMoney()));
            atmContext.addTransaction(transaction);
            int[] cash;
            cash = atmContext.InsertCashNotes();
            atmContext.DepositIntoAccount();
            System.out.println("You deposited " + atmContext.getUserMoney() + " with the following notes: HUNDRED(" + cash[0] + ") FIFTY(" + cash[1] + ") TWENTY(" + cash[2] + ") TEN(" + cash[3] + ")");

        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
    }

    public void execute(){
        try {
            System.out.println("\nPlease inform amount to deposit:");
            atmContext.setUserMoney(atmContext.scanNextInteger());
            this.depositMoney();
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
    }
}
