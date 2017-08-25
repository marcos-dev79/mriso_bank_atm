package com.risolabs.operations;

import com.risolabs.domain.Banknotes;
import com.risolabs.domain.Money;
import com.risolabs.exception.AtmException;
import com.risolabs.exception.InvalidCashException;
import com.risolabs.exception.OutOfCashException;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class MoneySupplier {

    private Banknotes banknotes;
    private int[] notesArray;
    private int[] divisor = new int[4];

    public MoneySupplier() throws AtmException {
        banknotes = new Banknotes();
        notesArray = new int[4];

        divisor[0] = 100;
        divisor[1] = 50;
        divisor[2] = 20;
        divisor[3] = 10;
    }

    public String MoneyAvailableStatement() {
        return banknotes.MoneyAvailableStatement();
    }

    public int[] withDrawCash(Integer moneyRequired) throws AtmException {

        notesArray = BankNotesRetrieverCalculator(moneyRequired);

        banknotes.Withdraw(Money.HUNDRED, notesArray[0]);
        banknotes.Withdraw(Money.FIFTY, notesArray[1]);
        banknotes.Withdraw(Money.TWENTY, notesArray[2]);
        banknotes.Withdraw(Money.TEN, notesArray[3]);

        return notesArray;
    }

    public int[] DepositCash(Integer moneyDeposited) throws AtmException {

        notesArray = BankNotesReceiver(moneyDeposited);

        banknotes.Deposit(Money.HUNDRED, notesArray[0]);
        banknotes.Deposit(Money.FIFTY, notesArray[1]);
        banknotes.Deposit(Money.TWENTY, notesArray[2]);
        banknotes.Deposit(Money.TEN, notesArray[3]);

        return notesArray;
    }

    private int[] BankNotesRetrieverCalculator(Integer moneyAsked) throws AtmException {

        int calc, division, AvailableBills, possibleMoney;
        int totalCashAvailable = banknotes.totalCash();
        calc = moneyAsked;

        int i = 0;
        do {
            if(calc > totalCashAvailable) {
                throw new OutOfCashException();
            }

            AvailableBills = banknotes.AvailableBill(divisor[i]);
            division = calc / divisor[i];

            if(AvailableBills >= division) {
                calc = calc % divisor[i];
                notesArray[i] = division;
            } else if ((AvailableBills < division) && AvailableBills > 0) {
                possibleMoney = AvailableBills * divisor[i];
                calc = calc - possibleMoney;
                notesArray[i] = AvailableBills;
            }
            else {
                notesArray[i] = 0;
            }

            if(calc > 0 && calc < 10) {
                throw new InvalidCashException();
            }

            i++;

        } while (i <= 3);

        return notesArray;

    }

    private int[] BankNotesReceiver(Integer moneyDeposited) throws AtmException {

        int calc, division;
        calc = moneyDeposited;

        int i = 0;
        do {

            division = calc / divisor[i];

            calc = calc % divisor[i];
            notesArray[i] = division;

            if(calc > 0 && calc < 10) {
                throw new InvalidCashException();
            }

            i++;

        } while (i <= 3);

        return notesArray;

    }

}
