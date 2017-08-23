package com.risolabs.operations;

import com.risolabs.domain.Account;
import com.risolabs.domain.MoneySupply;
import com.risolabs.exception.AbstractException;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class ATMinitializer {
    private ArrayList<Account> accounts;
    private MoneySupply moneySupply;

    public ATMinitializer() throws AbstractException {

        accounts = new ArrayList<>();

        BigDecimal acc1_money = new BigDecimal(10356.20);
        Account acc1 = new Account("Marcos Riso", acc1_money, "1978-12");
        accounts.add(acc1);

        moneySupply = new MoneySupply(1010);
    }

}
