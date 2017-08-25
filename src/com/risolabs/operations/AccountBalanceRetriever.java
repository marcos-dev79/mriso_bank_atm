package com.risolabs.operations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class AccountBalanceRetriever extends AbstractAtmOperations implements Operations {

    public AccountBalanceRetriever(AtmContext atmContext) {
        super(atmContext);
    }

    private void getBalance(){
        BigDecimal accountBalance = atmContext.getAccountBalance();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        String dateTime = LocalDateTime.now().format(formatter);
        System.out.println("\n");
        System.out.println("Your current net bank statement:");
        System.out.println(dateTime + " ... " + accountBalance.doubleValue());
        System.out.println("\n");
    }

    public void execute(){
        this.getBalance();
    }

}
