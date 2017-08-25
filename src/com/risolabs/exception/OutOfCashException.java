package com.risolabs.exception;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class OutOfCashException extends AtmException {

    public OutOfCashException(){
        super("This ATM can't provide this Cash. Please go to another ATM.");
    }

}
