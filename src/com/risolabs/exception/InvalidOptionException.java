package com.risolabs.exception;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class InvalidOptionException  extends AtmException {

    public InvalidOptionException(){
        super("\nOption not found. Please select one from menu.\n");
    }

}