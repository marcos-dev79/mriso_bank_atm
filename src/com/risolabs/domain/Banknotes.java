package com.risolabs.domain;

import com.risolabs.exception.AbstractException;
import com.risolabs.exception.InvalidInitialCashException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class Banknotes {

    Map<Money, Integer> banknotes;

    public Banknotes(Integer totalCash) throws AbstractException {


        Integer quarterValue = totalCash / 4;
        Integer nextValue;
        Integer mod;

        Integer qty100 = quarterValue / 100;
        Integer mod100 = Math.floorMod(quarterValue, 100);

        Integer qty50 = quarterValue / 50;
        Integer mod50 = Math.floorMod(quarterValue, 50);

        Integer qty20 = quarterValue / 20;
        Integer mod20 = Math.floorMod(quarterValue, 20);


        Integer qty10 = quarterValue / 10;
        Integer mod10 = Math.floorMod(quarterValue, 10);

        mod = mod10 + mod20 + mod50 + mod100;

        if(Math.floorMod(mod, 10) > 0){
            throw new InvalidInitialCashException();
        }else{
            qty10 = mod / 10;
        }



        banknotes = new HashMap<>();

        banknotes.put(Money.TEN, qty10);
        banknotes.put(Money.TWENTY, qty20);
        banknotes.put(Money.FIFTY, qty50);
        banknotes.put(Money.HUNDRED, qty100);

    }


}
