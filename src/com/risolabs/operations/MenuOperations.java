package com.risolabs.operations;

import com.risolabs.exception.AtmException;
import com.risolabs.exception.InvalidOptionException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class MenuOperations extends AbstractAtmOperations implements Operations {

    private Map<Integer, Operations> mappedMenu = new HashMap<>();

    public MenuOperations(final AtmContext atmContext) {
        super(atmContext);
        AccountBalanceOperation accountBalanceOperation = new AccountBalanceOperation(atmContext);
        AccountWithdrawOperation accountWithdrawOperation = new AccountWithdrawOperation(atmContext);
        AccountDepositOperation accountDepositOperation = new AccountDepositOperation(atmContext);
        ProgramFinalizeOperation programFinalizeOperation = new ProgramFinalizeOperation(atmContext);
        MoneyTransferOperation moneyTransferOperation = new MoneyTransferOperation(atmContext);
        BankStatementOperation bankStatementOperation = new BankStatementOperation(atmContext);
        LogoutOperation logoutOperation = new LogoutOperation(atmContext);

        mappedMenu.put(1, accountBalanceOperation);
        mappedMenu.put(2, accountWithdrawOperation);
        mappedMenu.put(3, accountDepositOperation);
        mappedMenu.put(4, moneyTransferOperation);
        mappedMenu.put(5, bankStatementOperation);
        mappedMenu.put(6, logoutOperation);
        mappedMenu.put(7, programFinalizeOperation);
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
