package com.risolabs.exception;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class InvalidInitialCashException extends AbstractException {

    public InvalidInitialCashException(){
        super("This Cash total is Invalid.");
    }

}
