package com.risolabs.exception;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class OutOfCashException extends AbstractException {

    public OutOfCashException(){
        super("This ATMProcessor is out of Cash. Please go to another ATMProcessor.");
    }

}
