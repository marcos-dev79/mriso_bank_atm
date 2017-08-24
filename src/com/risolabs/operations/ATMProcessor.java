package com.risolabs.operations;

import com.risolabs.domain.MoneySupply;
import com.risolabs.exception.AbstractException;
import com.risolabs.exception.AccountNotFoundException;


/**
 * Created by @mriso_dev on 23/08/17
 *
 * This class bootstrap UP the ATMProcessor system
 */
public class ATMProcessor {

    private MoneySupply moneySupply;
    private AccountManager accountManager;

    public ATMProcessor() throws AbstractException {
        accountManager = new AccountManager();
        moneySupply = new MoneySupply();
    }

    public boolean verifyAccount(final String accountNumber) throws AccountNotFoundException {
        return accountManager.verifyAccount(accountNumber);
    }

}
