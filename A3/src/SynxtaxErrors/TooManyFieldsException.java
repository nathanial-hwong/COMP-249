// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// -----------------------------------------------------
package SynxtaxErrors;

/**
 * TooManyFieldsException class creates a new Exception
 * @author Natha
 *
 */
public class TooManyFieldsException extends Exception{
	/**
	 * Default constructor for TooManyFieldsException class.
	 */
	public TooManyFieldsException() {
		super("Error: too many fields ");
	}
	/**
	 * Parameterized constructor which takes a string.
	 * @param s is a custom error message 
	 */
	public TooManyFieldsException(String s) {
		super(s);
	}
}
