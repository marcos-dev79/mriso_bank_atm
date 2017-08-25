package com.risolabs;

import com.risolabs.exception.AtmException;
import com.risolabs.operations.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AtmException {

        BannerPrinter.PrintBanner();
        boolean logged   = false;

        AtmContext atmContext = new AtmContext();
        AccountVerifier accountVerifier = new AccountVerifier(atmContext);

        while(logged == false) {
            String accountNumber = atmContext.scanNext();
            logged = accountVerifier.verifyAccount(accountNumber);
        }

        MenuOperations menuOperations = new MenuOperations(atmContext);

        while (atmContext.isSession()) {

            BannerPrinter.PrintMenu(atmContext.MoneyAvailableStatement());
            atmContext.setUserOption(atmContext.scanNextInteger());

            menuOperations.execute();

        }

    }

}
