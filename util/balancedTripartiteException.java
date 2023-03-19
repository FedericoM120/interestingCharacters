package util;

public class balancedTripartiteException extends Exception{
    private String tripartiteString;
    private int occurrenceIndex; //the first string index of the string index
    @Override
    public String getMessage() {
        return tripartiteString + " is a tripartite string that is found at index " + occurrenceIndex + "!";
    }
    public balancedTripartiteException(String tripartiteString, int index) {
        this.tripartiteString = tripartiteString;
        occurrenceIndex = index;
    }
}
