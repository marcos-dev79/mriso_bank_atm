package com.risolabs;

import com.risolabs.exception.AbstractException;
import com.risolabs.operations.ATMProcessor;
import com.risolabs.operations.BannerPrinter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AbstractException {

        BannerPrinter.PrintBanner();

        boolean session  = true;
        boolean logged   = false;

        int option = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Welcome to MRiso Bank! \n \n");
        System.out.print("Please Informe Account Number: \n");

        ATMProcessor atmProcessor = new ATMProcessor();

        while(logged == false) {
            String accountNumber = scan.next();
            logged = atmProcessor.verifyAccount(accountNumber);
        }


        while (session) {

            System.out.print("===============================\n"
                    +"ATM Menu: \n \n"
                    + "1. Check Account Balance \n"
                    + "2. Withdraw Money \n"
                    + "3. Deposit Money \n"
                    + "4. Transfer Funds \n"
                    + "5. Bank Statement\n"
                    + "6. End Session\n"
                    + "=======================================\n"
                    + "\nEnter selection: ");

            option = scan.nextInt();

            if(option == 6) {
                session = false;
            }
        }


    }

}
