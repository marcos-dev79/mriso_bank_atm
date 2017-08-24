package com.risolabs.exception;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class InvalidCashException extends AbstractException {

    public InvalidCashException(){
        super("Total cash supplied at ATM must be multiple of 10.");
    }

}
