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
    private static void singletonMiner(String mine, int length) throws SingletonException { // aaaaaaaa
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
        if (length % 2 != 0) {
            // Length is odd, skip and move on to the next length
            return;
        }
        int halfLength = length / 2;
        for (int start = 0; start <= mine.length() - length; start++) {
            String firstHalf = mine.substring(start, start + halfLength);
            String secondHalf = mine.substring(start + halfLength, start + length);
            if (firstHalf.equals(secondHalf)) {
                throw new balancedBipartiteStringException(mine.substring(start, start + length), start);
            }
        }
    }

    private static void balancedTripartiteString (String mine, int length) throws balancedTripartiteException{
        if (length % 3 != 0) {
            // Length is not divisible by 3, skip and move on to the next length
            return;
        }
        int partLength = length / 3;
        for (int start = 0; start <= mine.length() - length; start++) {
            String firstPart = mine.substring(start, start + partLength);
            String secondPart = mine.substring(start + partLength, start + 2 * partLength);
            String thirdPart = mine.substring(start + 2 * partLength, start + length);
            if (firstPart.equals(secondPart) && secondPart.equals(thirdPart)) {
                throw new balancedTripartiteException(mine.substring(start, start + length), start);
            }
        }
    }

    private static void palindrome(String mine, int length) throws PalindromeException { // aaaaaaaa
        for (int start = 0; start <= mine.length() - length; start++) {
            int i;
            for (i = 0; i < length / 2; i++) {
                if (mine.charAt(start + i) != mine.charAt(start + length - i - 1)) {
                    break;
                }
            }
            if (i == length / 2) {
                throw new PalindromeException(mine.substring(start, start + length), start);
            }
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //Step 1: handling input...
        System.out.println("Please enter the max pattern length. No larger than 15 or less than 3");
        int patternMaxLength = keyboard.nextInt();
        while (true) {
            try {
                if (patternMaxLength < 3 || patternMaxLength > 15) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException f) {
                System.out.println("Try again!");
                patternMaxLength = keyboard.nextInt();
                continue;
            }
            break;
        }
        System.out.println("Enter the length of random string: ");
        //int patternMaxLength = 10;//you need to update this part so that the value is given by the user via keyboard!
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
                singletonMiner(randomString, length);
                arithmeticStringOfOrder1Miner(randomString, length);
                arithmeticStringOfMinus1Miner(randomString, length);
                balancedBipartiteString(randomString, length);
                balancedTripartiteString(randomString, length);
                palindrome(randomString, length);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
