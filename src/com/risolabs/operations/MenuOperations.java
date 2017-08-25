package com.risolabs.operations;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class MenuOperations extends AbstractAtmOperations implements Operations {

    private AccountWithdrawer accountWithdrawer;
    private AccountBalanceRetriever accountBalanceRetriever;
    private AccountDepositer accountDepositer;
    private ProgramFinalizer programFinalizer;
    private Map<Integer, Operations> mappedMenu = new HashMap<>();

    public MenuOperations(final AtmContext atmContext) {
        super(atmContext);
        accountBalanceRetriever = new AccountBalanceRetriever(atmContext);
        accountWithdrawer = new AccountWithdrawer(atmContext);
        accountDepositer = new AccountDepositer(atmContext);
        programFinalizer = new ProgramFinalizer(atmContext);

        mappedMenu.put(1, accountBalanceRetriever);
        mappedMenu.put(2, accountWithdrawer);
        mappedMenu.put(3, accountDepositer);
        mappedMenu.put(6, programFinalizer);
    }

    public void execute(){
        Operations op = mappedMenu.get(atmContext.getUserOption());

        try {
            op.execute();
        } catch (NullPointerException e) {
            System.out.println("\nInvalid Option. Please select another.\n");
        }
    }
}
