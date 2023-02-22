package converter;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");

            String sourceBase = scanner.next();
            if (sourceBase.equals("/exit")) return;
            String targetBase = scanner.next();
            if (targetBase.equals("/exit")) return;

            System.out.println();

            while (true) {
                System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", sourceBase, targetBase);
                String numToConvert = scanner.next();
                if (numToConvert.equals("/back")) break;
                String[] numParts = numToConvert.split("\\.");

                String intPart = new BigInteger(numParts[0], Integer.parseInt(sourceBase)).toString();
                String convertedIntPart = new BigInteger(intPart).toString(Integer.parseInt(targetBase));

                // Convert integer or convert decimal number
                if (numParts.length == 1) {
                    System.out.printf("Conversion result: %s%n%n", convertedIntPart);
                } else {
                    // Convert fractional part to base 10
                    String fracBase10 = convertFracToBase10(numParts[1], Integer.parseInt(sourceBase));

                    // Convert base 10 fractional to the target base
                    String fracInTargetBase = convertFracToTargetBase(Double.parseDouble(fracBase10), Integer.parseInt(targetBase));


                    // Print out integer part and fractional part concatenated
                    System.out.println("Conversion result: " + convertedIntPart + "." + fracInTargetBase);
                    System.out.println();
                }
            }

            System.out.println();
        }
    }

    private static String convertFracToTargetBase(Double fracBase10, int targetBase) {
        StringBuilder targetBaseResult = new StringBuilder("");

        for (int i = 0; i < 5; i++) {
            fracBase10 *= targetBase;
            int intPart = fracBase10.intValue();
            char intAsChar = Character.forDigit(intPart, targetBase);
            targetBaseResult.append(intAsChar);
            fracBase10 -= intPart;
        }

        return targetBaseResult.toString();
    }

    private static String convertFracToBase10(String fractional, int sourceBase) {
        double base10Result = 0;
        for (int i = 0; i < fractional.length(); i++) {
            int num = Character.getNumericValue(fractional.charAt(i));
            base10Result += num * Math.pow(sourceBase, -(i + 1));
        }
        return Double.toString(base10Result);
    }
}
