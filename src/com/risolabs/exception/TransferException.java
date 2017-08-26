package com.risolabs.exception;

/**
 * Created by @mriso_dev on 26/08/17.
 */
public class TransferException extends AtmException {
    public TransferException(){
        super("\nError! Transfer Canceled.\n");
    }

}
