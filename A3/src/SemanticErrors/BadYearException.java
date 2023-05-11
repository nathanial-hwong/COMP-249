// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// -----------------------------------------------------
package SemanticErrors;

/**
 * BadYearException class creates a new Exception
 * @author Natha
 *
 */
public class BadYearException extends Exception{
	/**
	 * Default constructor for BadYearException class.
	 */
	public BadYearException() {
		super("Error: invalid year");
	}
	/**
	 * Parameterized constructor which takes a string.
	 * @param s is a custom error message 
	 */
	public BadYearException(String s) {
		super(s);
	}
}
