package util;

public class SingletonException extends Exception{//e.g. "bbbbbbb", "mmmm", "nn"
    private String singletonString;
    private int occurrenceIndex; //the first string index of the string index
    @Override
    public String getMessage() {
	return singletonString + " is a singleton string that is found at index " + occurrenceIndex + "!";
    }
    public SingletonException(String singletonString, int index) {
	this.singletonString = singletonString; 
	occurrenceIndex = index;
    }
}
