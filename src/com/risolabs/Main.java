package com.risolabs;

import com.risolabs.exception.AtmException;
import com.risolabs.operations.AtmOperations;
import com.risolabs.operations.BannerPrinter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AtmException {

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

            // TODO: 24/08/17 - Remove IFs for a more advanced technique

            if(option == 1) {
                atmOperations.getAccountBalance();
            } else if(option == 2) {
                System.out.print("\nPlease inform value to be Withdraw: \n");
                Integer moneyRequired = scan.nextInt();
                atmOperations.withDrawCash(moneyRequired);
            } else if (option == 3) {
                System.out.print("\nPlease inform value to be Deposited (Accepts only 10, 20, 50 or 100 notes) \n ");
                System.out.print("\nCash ammount: \n");
                Integer moneyDeposited = scan.nextInt();
                atmOperations.depositMoney(moneyDeposited);
            } else if (option == 4) {
                System.out.print("\nComming Soon! \n");
            } else if (option == 5) {
                System.out.print("\nComming Soon! \n");
            } else if(option == 6) {
                session = false;
            }
            else {
                System.out.println("\nUnknown Option. Try Again. \n");
            }

        }


    }

}
