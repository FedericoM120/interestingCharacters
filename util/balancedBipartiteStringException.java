package util;

public class balancedBipartiteStringException extends Exception{
    private String bipartiteString;
    private int occurrenceIndex; //the first string index of the string index
    @Override
    public String getMessage() {
        return bipartiteString + " is a bipartite string that is found at index " + occurrenceIndex + "!";
    }
    public balancedBipartiteStringException(String bipartiteString, int index) {
        this.bipartiteString = bipartiteString;
        occurrenceIndex = index;
    }
}
