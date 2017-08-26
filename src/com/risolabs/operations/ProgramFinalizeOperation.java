package com.risolabs.operations;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class ProgramFinalizeOperation extends AbstractAtmOperations implements Operations {

    public ProgramFinalizeOperation(AtmContext atmContext) {
        super(atmContext);
    }

    public void execute(){
        atmContext.setSession(false);
        System.out.println("\nThank you, and see you soon.\n");
    }
}
