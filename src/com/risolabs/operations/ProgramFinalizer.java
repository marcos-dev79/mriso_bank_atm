package com.risolabs.operations;

import com.risolabs.exception.AtmException;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class ProgramFinalizer extends AbstractAtmOperations implements Operations {

    public ProgramFinalizer(AtmContext atmContext) {
        super(atmContext);
    }

    public void execute(){
        atmContext.setSession(false);
        System.out.println("\nThank you, and see you soon.\n");
    }
}
