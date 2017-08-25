package com.risolabs.operations;

import com.risolabs.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class BankStatementOperation extends AbstractAtmOperations implements Operations {

    public BankStatementOperation(AtmContext atmContext) {
        super(atmContext);
    }

    private void PrintBankStatement(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        String dateTime = LocalDateTime.now().format(formatter);

        String operationdate;
        Integer operation;
        BigDecimal opValue;

        System.out.println("\nBank Statement "+dateTime+"\n");
        System.out.println("==============================================\n");

        for(Transaction atm : atmContext.getTransactionList()) {
            operationdate = atm.getDatetime().format(formatter);
            operation = atm.getOperation();
            opValue = atm.getValue();

            System.out.println(operationdate + " ... " + " Operation: " + operation.toString() + " ... " + opValue.toString());
        }

    }

    public void execute () {

    }

}
