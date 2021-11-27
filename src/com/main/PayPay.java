package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PayPay {


    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(countChange(line));
        }
    }

    private static String countChange(String line) {
        String[] input = line.split(";");
        float cash = Float.parseFloat(input[0]);
        float price = Float.parseFloat(input[1]);

        double change = price - cash;

        return totalChange(change);
    }

    private static String totalChange(double change) {
        if (change < 0) {
            return "ERROR";
        } else if (change == 0) {
            return "ZERO";
        } else {
            return findChange(change);
        }
    }


    private static String findChange(double change) {
        List<String> resultChange = new ArrayList<>();
        DecimalFormat decimalFormat = new DecimalFormat("########.##");
        int countChange = (int) (Double.parseDouble(decimalFormat.format(change)) * 100);

        for (RegisterCoin coin : RegisterCoin.values()) {
            if (countChange >= coin.getValue()) {
                countChange -= coin.getValue();
                resultChange.add(String.valueOf(coin));
            }
        }
        return String.join(",", resultChange);
    }


    public enum RegisterCoin {
        ONE_HUNDRED(10000),
        FIFTY(5000),
        TWENTY(2000),
        TEN(1000),
        FIVE(500),
        TWO(200),
        ONE(100),
        HALF_DOLLAR(50),
        QUARTER(25),
        DIME(10),
        NICKEL(5),
        PENNY(1);

        private final int value;
        private final String description;

        RegisterCoin(int value) {
            this.value = value;
            this.description = this.name().replace("_", " ");
        }

        public int getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.description;
        }

    }

}
