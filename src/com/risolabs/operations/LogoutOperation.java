package com.risolabs.operations;

/**
 * Created by @mriso_dev on 25/08/17.
 */
public class LogoutOperation extends AbstractAtmOperations implements Operations {

    public LogoutOperation(AtmContext atmContext) {
        super(atmContext);
    }

    public void execute(){
        atmContext.setLogged(false);
        System.out.println("\nGood Bye. Login again to continue.\n");
    }
}
