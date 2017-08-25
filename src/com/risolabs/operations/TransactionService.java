package com.risolabs.operations;

import com.risolabs.domain.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class TransactionService {

    private List<Transaction> transactions;

    public TransactionService(){
        super();
        transactions = new ArrayList<>();
    }

    public void addToList(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getListOfTransactions() {
        return transactions;
    }

}
