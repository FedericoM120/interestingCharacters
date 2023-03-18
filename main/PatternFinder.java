package main;

import util.*;

import java.util.*;

public class PatternFinder {
    private static String randomStringGenerator(int length) {// generates a string made of randomly generated lowercase
        // letters.
        Random random = new Random(System.nanoTime());
        char[] array = new char[length];
        for (int i = 0; i < length; i++)
            array[i] = (char) ('a' + random.nextInt(26));
        return new String(array);
    }

    //need to create similar patterns for each 6 methods
    private static void singletonMiner(String mine, int length) throws SingletonException {
        for (int start = 0; start < mine.length() - length; start++) {
            int i;
            for (i = start + 1; i < start + length; i++)
                if (mine.charAt(i) != mine.charAt(i - 1))
                    break;
            	if (i == start + length)
                	throw new SingletonException(mine.substring(start, start + length), start);
        }
    }

    private static void arithmeticStringOfOrder1Miner(String mine, int length) throws ArithmeticOrder1Exception {
        for (int start = 0; start < mine.length() - length; start++) {
            int i;
            for (i = start + 1; i < start + length; i++){
                if (mine.charAt(i) - mine.charAt(i - 1) != 1) {
                    break;
                }
            }
            if (i == start + length){
                throw new ArithmeticOrder1Exception(mine.substring(start, start + length), start);
            }
        }
    }

    private static void arithmeticStringOfMinus1Miner(String mine, int length) throws arithmeticStringOfMinus1Miner {
        for (int start = 0; start < mine.length() - length; start++) {
            int i;
            for (i = start + 1; i < start + length; i++){
                if (mine.charAt(i) - mine.charAt(i - 1) != - 1) {
                    break;
                }
            }
            if (i == start + length){
                throw new arithmeticStringOfMinus1Miner(mine.substring(start, start + length), start);
            }
        }
    }

    private static void balancedBipartiteString (String mine, int length) throws balancedBipartiteStringException{
        for (int start = 0; start < mine.length() - length; start++) {
            int i;
            int halfLength = mine.length() /2;
            String firstHalf = mine.substring(0, halfLength);
            String secondHalf = mine.substring(halfLength);
            for (i = start; i < start + halfLength && i < start + length; i++) {
                if (firstHalf.charAt(i) != secondHalf.charAt(i)) {
                    break;
                }
            }
            if (i == start + length){
                throw new balancedBipartiteStringException(mine.substring(start, start + length), start);
            }
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //Step 1: handling input...
        System.out.println("Enter the length of random string: ");
        int patternMaxLength = 10;//you need to update this part so that the value is given by the user via keyboard!
        int randomStringLength = keyboard.nextInt();
        while (true) {
            try {
                if (randomStringLength < 100000 || randomStringLength > 1000000000)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Try again!");
                randomStringLength = keyboard.nextInt();
                continue;
            }
            break;
        }
        //Step 2: generating random string...
        String randomString = randomStringGenerator(randomStringLength);
        //Step 3: finding the interesting patterns
        try {
            for (int length = patternMaxLength; length > 0; length--) {
                balancedBipartiteString(randomString, length);
            }
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        try {
            for (int length = patternMaxLength; length > 0; length--) {
                arithmeticStringOfMinus1Miner(randomString, length);
            }
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        try {
            for (int length = patternMaxLength; length > 0; length--) {
                arithmeticStringOfOrder1Miner(randomString, length);
            }
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        try {
            for (int length = patternMaxLength; length > 0; length--)
                singletonMiner(randomString, length);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }
}
