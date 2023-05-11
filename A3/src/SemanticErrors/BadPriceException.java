// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// -----------------------------------------------------
package SemanticErrors;

/**
 * BadPriceException class creates a new Exception
 * @author Natha
 *
 */
public class BadPriceException extends Exception{
	/**
	 * Default constructor for BadPriceException class.
	 */
	public BadPriceException() {
		super("Error: invalid price");
	}
	/**
	 * Parameterized constructor which takes a string.
	 * @param s is a custom error message 
	 */
	public BadPriceException(String s) {
		super(s);
	}
}
