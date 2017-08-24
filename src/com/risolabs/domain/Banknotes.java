package com.risolabs.domain;

import com.risolabs.exception.AbstractException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class Banknotes {

    private Map<Money, Integer> banknotes;

    public Banknotes() throws AbstractException {

        banknotes = new HashMap<>();

        banknotes.put(Money.TEN, 15);
        banknotes.put(Money.TWENTY, 5);
        banknotes.put(Money.FIFTY, 5);
        banknotes.put(Money.HUNDRED, 5);

    }

    public Integer Withdraw(Money money, Integer bills){
        Integer current = banknotes.get(money);
        if(current >= bills) {
            banknotes.put(money, current - bills);
        }else{
            return 0;
        }
        return bills;
    }




}
