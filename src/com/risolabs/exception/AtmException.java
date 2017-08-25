package com.risolabs.exception;

/**
 * Created by @mriso_dev on 23/08/17
 */
public abstract class AtmException extends Exception {

    public AtmException(){
        super();
    }

    public AtmException(String message) {
        super(message);
    }
}
