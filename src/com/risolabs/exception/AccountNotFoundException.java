package com.risolabs.exception;

/**
 * Created by @mriso_dev on 24/08/17
 */
public class AccountNotFoundException extends AbstractException {
    public AccountNotFoundException(){
        super("Account not found! Program aborted.");
    }
}