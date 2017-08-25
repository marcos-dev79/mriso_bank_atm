package com.risolabs.operations;

import com.risolabs.exception.AtmException;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class AccountVerifier extends AbstractAtmOperations {

    public AccountVerifier(AtmContext atmContext) {
        super(atmContext);
    }

    public boolean verifyAccount(String accountNumber) throws AtmException {
        return atmContext.verifyAccount(accountNumber);
    }

}
