package util;

public class PalindromeException extends Exception {
    private String palindromeString;
    private int occurrenceIndex; //the first string index of the string index
    @Override
    public String getMessage() {
        return palindromeString + " is a palindrome string that is found at index " + occurrenceIndex + "!";
    }
    public PalindromeException(String palindrome, int index) {
        this.palindromeString = palindrome;
        occurrenceIndex = index;
    }
}
