package com.risolabs;

import com.risolabs.exception.AbstractException;
import com.risolabs.operations.AtmOperations;
import com.risolabs.operations.BannerPrinter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AbstractException {

        BannerPrinter.PrintBanner();

        System.out.print("Welcome to MRiso Bank! \n \n");
        System.out.print("Please Informe Account Number: ");

        boolean session  = true;
        boolean logged   = false;
        int option = 0;
        Scanner scan = new Scanner(System.in);

        AtmOperations atmOperations = new AtmOperations();

        while(logged == false) {
            String accountNumber = scan.next();
            logged = atmOperations.verifyAccount(accountNumber);
        }

        while (session) {

            BannerPrinter.PrintMenu(atmOperations.MoneyAvailableStatement());
            option = scan.nextInt();

            // TODO: 24/08/17 - Remove IFs

            if(option == 1) {

                atmOperations.getAccountBalance();

            } else if(option == 2) {

                System.out.print("Please inform value to be Withdraw: ");
                Integer moneyRequired = scan.nextInt();
                atmOperations.withDrawCash(moneyRequired);

            } else if (option == 3) {

                System.out.print("Please inform value to be Deposited (Accepts only 10, 20, 50 or 100 notes) \n ");

                System.out.print("Cash ammount: ");
                Integer moneyRequired = scan.nextInt();

                atmOperations.depositMoney(moneyRequired);


            } else if(option == 6) {

                session = false;

            }
            else {
                System.out.println("Unknown Option. Try Again.");
            }

        }


    }

}
