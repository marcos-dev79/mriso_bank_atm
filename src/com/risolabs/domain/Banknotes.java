package com.risolabs.domain;

import com.risolabs.exception.AtmException;
import com.risolabs.exception.OutOfCashException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by @mriso_dev on 23/08/17
 */
public class Banknotes {

    private Map<Money, Integer> banknotes;

    public Banknotes() throws AtmException {

        banknotes = new HashMap<>();

        banknotes.put(Money.TEN, 15);
        banknotes.put(Money.TWENTY, 5);
        banknotes.put(Money.FIFTY, 5);
        banknotes.put(Money.HUNDRED, 5);

    }

    public Integer Withdraw(Money money, Integer bills) throws OutOfCashException {
        Integer current = banknotes.get(money);
        if(current >= bills) {
            banknotes.put(money, current - bills);
        }else{
            throw new OutOfCashException();
        }
        return bills;
    }


    public Integer Deposit(Money money, Integer bills) {
        Integer current = banknotes.get(money);
        banknotes.put(money, current + bills);

        return bills;
    }

    public Integer AvailableBill(Integer cash) {

        Money money = Money.HUNDRED;

        if(cash == 100){
            money = Money.HUNDRED;
        } else if (cash == 50) {
            money = Money.FIFTY;
        } else if (cash == 20) {
            money = Money.TWENTY;
        } else if (cash == 10) {
            money = Money.TEN;
        }

        return banknotes.get(money);
    }

    public Integer totalCash(){
        return (banknotes.get(Money.TEN) * Money.TEN.getValue()) +
               (banknotes.get(Money.TWENTY) * Money.TWENTY.getValue()) +
               (banknotes.get(Money.FIFTY) * Money.FIFTY.getValue()) +
               (banknotes.get(Money.HUNDRED) * Money.HUNDRED.getValue());
    }

    public String MoneyAvailableStatement () {
        Integer ten     = banknotes.get(Money.TEN);
        Integer twenty  = banknotes.get(Money.TWENTY);
        Integer fifty   = banknotes.get(Money.FIFTY);
        Integer hundred = banknotes.get(Money.HUNDRED);

        return "Available banknotes: TEN (" + ten.toString() + ") TWENTY (" + twenty.toString() + ") FIFTY (" + fifty.toString() + ") HUNDRED (" + hundred.toString() + ")";
    }



}
