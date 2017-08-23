package com.risolabs.exception;

/**
 * Created by @mriso_dev on 23/08/17
 */
public abstract class AbstractException extends Exception {

    public AbstractException(){
        super();
    }

    public AbstractException(String message) {
        super(message);
    }
}
