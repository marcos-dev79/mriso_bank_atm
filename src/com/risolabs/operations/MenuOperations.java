package com.risolabs.operations;

import com.risolabs.exception.AtmException;
import com.risolabs.exception.InvalidOptionException;

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
    private BankStatementOperation bankStatementOperation;
    private Map<Integer, Operations> mappedMenu = new HashMap<>();

    public MenuOperations(final AtmContext atmContext) {
        super(atmContext);
        accountBalanceRetriever = new AccountBalanceRetriever(atmContext);
        accountWithdrawer = new AccountWithdrawer(atmContext);
        accountDepositer = new AccountDepositer(atmContext);
        programFinalizer = new ProgramFinalizer(atmContext);
        bankStatementOperation = new BankStatementOperation(atmContext);

        mappedMenu.put(1, accountBalanceRetriever);
        mappedMenu.put(2, accountWithdrawer);
        mappedMenu.put(3, accountDepositer);
        mappedMenu.put(5, bankStatementOperation);
        mappedMenu.put(6, programFinalizer);
    }

    public void execute() throws InvalidOptionException {
        Operations op = mappedMenu.get(atmContext.getUserOption());
        try {
            op.execute();
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            throw new InvalidOptionException();
        }
    }
}
