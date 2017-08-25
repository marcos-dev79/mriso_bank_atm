package com.risolabs.exception;

/**
 * Created by @mriso_dev on 24/08/17
 */
public class AccountWithoutFundsException extends AtmException {

    public AccountWithoutFundsException(){
        super("You don't have funds for this transaction.");
    }

}