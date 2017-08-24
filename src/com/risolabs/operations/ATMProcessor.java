package com.risolabs.operations;

import com.risolabs.domain.Account;
import com.risolabs.domain.MoneySupply;
import com.risolabs.exception.AbstractException;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by @mriso_dev on 23/08/17
 *
 * This class bootstrap UP the ATMProcessor system
 */
public class ATMProcessor {

    private ArrayList<Account> accounts;
    private MoneySupply moneySupply;

    public ATMProcessor() throws AbstractException {

        accounts = new ArrayList<>();
        Account acc1 = new Account("Marcos Riso", new BigDecimal(10356.20), "1978-12");
        Account acc2 = new Account("Cassia Riso", new BigDecimal(1356.20), "1978-13");
        Account acc3 = new Account("Mané Riso", new BigDecimal(356.20), "1278-13");
        Account acc4 = new Account("João Riso", new BigDecimal(3576.20), "2279-15");

        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);
        accounts.add(acc4);

        moneySupply = new MoneySupply();
    }

}
