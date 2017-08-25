package com.risolabs.exception;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class InvalidCashException extends AtmException {

    public InvalidCashException(){
        super("Your request is not available.");
    }

}
