// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// -----------------------------------------------------
package SynxtaxErrors;

/**
 * TooFewFieldsException class creates a new Exception
 * @author Natha
 *
 */
public class TooFewFieldsException extends Exception{
	/**
	 * Default constructor for TooFewFieldsException class.
	 */
	public TooFewFieldsException() {
		super("Error: too few fields");
	}
	/**
	 * Parameterized constructor which takes a string.
	 * @param s is a custom error message 
	 */
	public TooFewFieldsException(String s) {
		super(s);
	}
}
