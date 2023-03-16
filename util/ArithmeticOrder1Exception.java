package util;

public class ArithmeticOrder1Exception extends Exception{
    private String ArthmeticString1;
    private int occurrenceIndex; //the first string index of the string index
    @Override
    public String getMessage() {
        return ArthmeticString1 + " is a arthmetic string that is found at index " + occurrenceIndex + "!";
    }
    public ArithmeticOrder1Exception(String ArthmeticString1, int index) {
        this.ArthmeticString1 = ArthmeticString1;
        occurrenceIndex = index;
    }
}
