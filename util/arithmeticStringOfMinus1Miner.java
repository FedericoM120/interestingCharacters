package util;

public class arithmeticStringOfMinus1Miner extends Exception{
    private String NegativeArthmeticString1;
    private int occurrenceIndex; //the first string index of the string index
    @Override
    public String getMessage() {
        return NegativeArthmeticString1 + " is a backwards arthmetic string that is found at index " + occurrenceIndex + "!";
    }
    public arithmeticStringOfMinus1Miner(String ArthmeticString1, int index) {
        this.NegativeArthmeticString1 = ArthmeticString1;
        occurrenceIndex = index;
    }
}
