package com.risolabs.operations;

import com.risolabs.exception.AtmException;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class AccountWithdrawer extends AbstractAtmOperations implements Operations {

    public AccountWithdrawer(AtmContext atmContext) {
        super(atmContext);
    }

    private void withdrawCash() throws AtmException {
        try {
            int[] cash;
            cash = atmContext.RequestCashNotes();
            atmContext.DebitFromAccount();
            System.out.println("Take your notes: HUNDRED(" + cash[0] + ") FIFTY(" + cash[1] + ") TWENTY(" + cash[2] + ") TEN(" + cash[3] + ")");
        } catch(AtmException e) {
            System.out.println(e.getMessage());
        }
    }

    public void execute(){
        try {
            System.out.println("\nPlease inform amount to withdraw:");
            atmContext.setUserMoney(atmContext.scanNextInteger());
            this.withdrawCash();
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
    }
}
