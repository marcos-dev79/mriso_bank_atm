package com.risolabs.operations;

import com.risolabs.domain.Transaction;
import com.risolabs.exception.AtmException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by @mriso_dev on 25/08/17.
 */
public class MoneyTransferOperation extends AbstractAtmOperations implements Operations {

    public MoneyTransferOperation(AtmContext atmContext) {
        super(atmContext);
    }

    private void MoneyTransfer() throws AtmException {
        try {

            System.out.println("\nPlease inform account to deposit:");
            String accountNumber = atmContext.scanNext();
            System.out.println("\nPlease inform amount money to deposit:");
            Integer value = atmContext.scanNextInteger();

            atmContext.TransferIntoAccount(accountNumber, BigDecimal.valueOf(value));

        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
    }

    public void execute() {
        try {

            this.MoneyTransfer();
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
    }
}
