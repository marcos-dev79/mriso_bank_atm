package com.risolabs.domain;

import com.risolabs.exception.AbstractException;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class MoneySupply {

    private Banknotes banknotes;

    public MoneySupply() throws AbstractException {
        banknotes = new Banknotes();
    }



}
