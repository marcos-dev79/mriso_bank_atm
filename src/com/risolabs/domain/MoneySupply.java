package com.risolabs.domain;

import com.risolabs.exception.AbstractException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class MoneySupply {

    Banknotes banknotes;

    public MoneySupply(int totalCash) throws AbstractException {
        this.banknotes = new Banknotes(totalCash);
    }


}
