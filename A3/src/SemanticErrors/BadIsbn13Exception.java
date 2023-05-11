// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// -----------------------------------------------------
package SemanticErrors;

/**
 * BadIsbn13Exception class creates a new Exception
 * @author Natha
 *
 */
public class BadIsbn13Exception extends Exception{
	/**
	 * Default constructor for BadIsbn13Exception class.
	 */
	public BadIsbn13Exception() {
		super("Error: invalid ISBN 13");
	}
	/**
	 * Parameterized constructor which takes a string.
	 * @param s is a custom error message 
	 */
	public BadIsbn13Exception(String s) {
		super(s);
	}
}
