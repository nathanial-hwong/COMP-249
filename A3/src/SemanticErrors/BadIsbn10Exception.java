// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// -----------------------------------------------------

package SemanticErrors;

/**
 * BadIsbn10Exception class creates a new Exception
 * @author Natha
 *
 */
public class BadIsbn10Exception extends Exception{
	/**
	 * Default constructor for BadIsbn10Exception class.
	 */
	public BadIsbn10Exception() {
		super("Error: invalid ISBN 10");
	}
	/**
	 * Parameterized constructor which takes a string.
	 * @param s is a custom error message 
	 */
	public BadIsbn10Exception(String s) {
		super(s);
	}
}
