package com.risolabs;

import com.risolabs.exception.AtmException;
import com.risolabs.operations.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AtmException {

        BannerPrinter.PrintBanner();

        AtmContext atmContext = new AtmContext();
        AccountVerifier accountVerifier = new AccountVerifier(atmContext);
        MenuOperations menuOperations = new MenuOperations(atmContext);


        while(atmContext.isSession()) {
            System.out.print("Please Informe Account Number: ");
            String accountNumber = atmContext.scanNext();

            try {
                atmContext.setLogged(accountVerifier.verifyAccount(accountNumber));
            } catch (AtmException e) {
                System.out.println(e.getMessage());
                break;
            }

            while (atmContext.isSession() && atmContext.isLogged()) {

                BannerPrinter.PrintMenu(atmContext.MoneyAvailableStatement());
                atmContext.setUserOption(atmContext.scanNextInteger());

                try {
                    menuOperations.execute();
                } catch (AtmException e) {
                    System.out.println(e.getMessage());
                }

            }


        }


    }

}
