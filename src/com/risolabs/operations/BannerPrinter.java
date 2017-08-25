package com.risolabs.operations;


/**
 * Created by @mriso_dev on 24/08/17
 */
public class BannerPrinter {

    public static void PrintBanner() {
        String banner = "\n" +
                "$$\\      $$\\ $$$$$$$\\  $$\\                           $$$$$$$\\                      $$\\       \n" +
                "$$$\\    $$$ |$$  __$$\\ \\__|                          $$  __$$\\                     $$ |      \n" +
                "$$$$\\  $$$$ |$$ |  $$ |$$\\  $$$$$$$\\  $$$$$$\\        $$ |  $$ | $$$$$$\\  $$$$$$$\\  $$ |  $$\\ \n" +
                "$$\\$$\\$$ $$ |$$$$$$$  |$$ |$$  _____|$$  __$$\\       $$$$$$$\\ | \\____$$\\ $$  __$$\\ $$ | $$  |\n" +
                "$$ \\$$$  $$ |$$  __$$< $$ |\\$$$$$$\\  $$ /  $$ |      $$  __$$\\  $$$$$$$ |$$ |  $$ |$$$$$$  / \n" +
                "$$ |\\$  /$$ |$$ |  $$ |$$ | \\____$$\\ $$ |  $$ |      $$ |  $$ |$$  __$$ |$$ |  $$ |$$  _$$<  \n" +
                "$$ | \\_/ $$ |$$ |  $$ |$$ |$$$$$$$  |\\$$$$$$  |      $$$$$$$  |\\$$$$$$$ |$$ |  $$ |$$ | \\$$\\ \n" +
                "\\__|     \\__|\\__|  \\__|\\__|\\_______/  \\______/       \\_______/  \\_______|\\__|  \\__|\\__|  \\__|\n" +
                "                                                                                             \n" +
                "                                                                                             \n" +
                "                                                                                             \n";

        System.out.println(banner);
    }

    public static void PrintMenu(String moneyAvailableStatement) {
        System.out.print("\n===============================\n"
                +"ATM Menu: \n \n"
                + "1. Check Account Balance \n"
                + "2. Withdraw Money (" + moneyAvailableStatement + ") \n"
                + "3. Deposit Money \n"
                + "4. Transfer Funds \n"
                + "5. Bank Statement\n"
                + "6. End Session\n"
                + "=======================================\n"
                + "\nEnter selection: \n");
    }
}
