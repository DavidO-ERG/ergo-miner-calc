package portugal.ergo.views;
import portugal.ergo.tools.*;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Scanner;
import java.text.DecimalFormat;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;
import java.time.Instant;

public class Cli {
    public static void cli() {

        // Define Variables
        double ergoPrice;
        double userHashrate;
        double userWattsHour;
        double userHours;
        double userPriceKwHour;
        double networkBlockTime;
        double networkBlockRewards;
        double networkHashrate;
        boolean continueCalc = true;
        boolean userQuestion = true;
        Scanner scanInput = new Scanner(System.in);

        // Format Decimals
        DecimalFormat df = new DecimalFormat("0.00");

        // Start Program
        System.out.println("--------------------------------------------------");
        System.out.println("    Welcome fellow Miner!");
        System.out.println("    This is a simple calculator that returns the\napproximate Revenue/Cost values of your Mining Farm.\n");
        System.out.println("    Let's begin!");
        System.out.println("--------------------------------------------------");

        // Define APIs to connect
        URL apiPrice = null;
        URL apiNetwork = null;
        try {
            apiPrice = new URL("https://api.tokenjay.app/tokens/prices/03faf2cb329f2e90d6d23b58d91bbb6c046aa143261cc21f52fbe2824bfcbf04");
            apiNetwork = new URL("https://whattomine.com/coins/340.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Make API Calls
        double currentPrice = (Long) Apis.makeApiCall("TokenJayApp", apiPrice).get("price") / 100_000_000.00;
        String[] currentNetwork = new String[] { Apis.makeApiCall("WhatToMine", apiNetwork).get("nethash").toString(),
                                                 Apis.makeApiCall("WhatToMine", apiNetwork).get("block_reward").toString(),
                                                 Apis.makeApiCall("WhatToMine", apiNetwork).get("block_time").toString(),};


        if (currentPrice != 0.00 && currentNetwork[2] != null) {
            System.out.println("API/s connected successfully.");
        } else {
            System.out.println("API/s failed to connect.");
        }

        while (continueCalc) {

            // Input Ergo Price (€ or $)
            System.out.println("\nCurrent Ergo Price?");
            if (currentPrice != 0.00) {
                ergoPrice = currentPrice;
                System.out.println(ergoPrice);
            } else {
                ergoPrice = scanInput.nextDouble();
                //ergoPrice = 3.133;  // Example
            }

            // Input User Hashrate
            System.out.println("Your Hashrate (in MH/s)?");
            userHashrate = scanInput.nextDouble();
            //userHashrate = 500;  // Example

            // Input User Watts per Hour
            System.out.println("Your Watts/hour?");
            userWattsHour = scanInput.nextDouble();
            //userWattsHour = 500;  // Example

            // Input User Price per Kilowatt Hour
            System.out.println("Your Price per Kw/h?");
            userPriceKwHour = scanInput.nextDouble();
            //userPriceKwHour = 0.20;  // Example

            // Input User Price per Kilowatt Hour
            System.out.println("How many hours mining?");
            userHours = scanInput.nextDouble();
            //userHours = 24;  // Example

            // Input Network Block Rewards
            System.out.println("Current Network Block Rewards?");
            if (currentNetwork[1] != null) {
                networkBlockRewards = parseDouble(currentNetwork[1]);
                System.out.println(networkBlockRewards);
            } else {
                networkBlockRewards = scanInput.nextDouble();
                //networkBlockRewards = 48.03;  // Example
            }

            // Input Network Block Time
            System.out.println("Current Network Block Time?");
            if (currentNetwork[2] != null) {
                networkBlockTime = parseDouble(currentNetwork[2]) / 60.00;
                System.out.println(networkBlockTime);
            } else {
                networkBlockTime = scanInput.nextDouble();
                //networkBlockTime = 2.06;  // Example
            }

            // Input Network Hashrate (Total)
            System.out.println("Current Total Network Hashrate?");
            if (currentNetwork[0] != null) {
                networkHashrate = parseLong(currentNetwork[0]) / 1_000_000.00;
                System.out.println(networkHashrate);
            } else {
                networkHashrate = scanInput.nextLong() / 1_000_000.00;
                //networkHashrate = 12009220070855L / 1_000_000.00;  // Example
            }

            // Return Calculations to Miner
            System.out.println("--------------------------------------------------");
            String message = """
                    .______      _______    _______. __    __   __   .___________.   _______. \s
                    |   _  \\   |   ____|  /       ||  |  |  | |  |  |           |  /       | \s
                    |  |_)  |  |  |__    |   (----`|  |  |  | |  |  `---|  |----` |   (----` \s
                    |      /   |   __|     \\   \\   |  |  |  | |  |      |  |       \\   \\   \s
                    |  |\\  \\   | |____.----)   |   |  `--'  | |  `----. |  |    ----)   |  \s
                    | _| `.__\\_|_______|_______/    \\______/  |_______| |__|   |_______/   \s
                    """;

            double farmRevenue =  Functions.dailyReturns(networkBlockRewards, ergoPrice, networkHashrate, userHashrate, networkBlockTime);
            double farmCost = Functions.dailyCost(userWattsHour, userHours, userPriceKwHour);
            double farmProfit = farmRevenue - farmCost;
            double farmMined = Functions.minedReturnsErg(networkBlockRewards, userHashrate, networkHashrate, networkBlockTime);

            System.out.println();
            System.out.println(message);
            System.out.println("--------------------------------------------------");
            System.out.println("Network Values - Paid to All Miners");
            System.out.println("--------------------------------------------------");
            System.out.println("    Block Rewards (in Erg): " + df.format(Functions.dailyBlockRewards(networkBlockRewards, networkBlockTime)) + " ERG");
            System.out.println("    Block Rewards (in Value): " + df.format(Functions.dailyBlockRewardsInValue(networkBlockRewards, ergoPrice, networkBlockTime)) + " \u0024");
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("Your Mining Farm");
            System.out.println("--------------------------------------------------");
            System.out.println("    Mining Farm Revenue: " + df.format(farmRevenue) + "  \u0024");
            System.out.println("    Mining Farm Cost: " + df.format(farmCost) + " \u0024");
            System.out.println();
            System.out.println("    Total Mined - Profit: " + df.format(farmProfit) + " \u0024");
            System.out.println("    Total Mined - Tokens: " + df.format(farmMined) + " ERG");
            System.out.println("--------------------------------------------------");
            String date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").withZone(ZoneId.systemDefault()).format(Instant.now());
            System.out.println(date);
            System.out.println();

            // Save FarmStats
            double[] arrayStats = {ergoPrice, userHashrate, userWattsHour, userHours, userPriceKwHour, networkBlockTime, networkBlockRewards, networkHashrate, farmRevenue, farmCost, farmProfit, farmMined };
            Functions.saveFarmStats(date, arrayStats);

            // Ask user to recalculate or exit the program
            while (userQuestion) {
                System.out.println("Do you wish to 'Recalculate' or to 'Exit'? ");
                String userInput = scanInput.next().toLowerCase();

                switch (userInput) {
                    case "exit", "e", "quit", "q":
                        continueCalc = false;
                        userQuestion = false;
                        scanInput.close();
                        break;
                    case "calc", "recalc", "recalculate":
                        userQuestion = false;
                        break;
                    case "ergo":
                        System.out.println("The True Ergonaut!!!\nCongratulations! :)\n");
                        break;
                    default:
                        System.out.println("My apologies but I didn't understand. Can you repeat that.");
                        break;
                }
            }
        }
    }
}
