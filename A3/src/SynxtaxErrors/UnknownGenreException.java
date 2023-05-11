// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// -----------------------------------------------------
package SynxtaxErrors;

/**
 * UnknownGenreException class creates a new Exception
 * @author Natha
 *
 */
public class UnknownGenreException extends Exception{
	/**
	 * Default constructor for UnknownGenreException class.
	 */
	public UnknownGenreException() {
		super("Error: invalid genre");
	}
	/**
	 * Parameterized constructor which takes a string.
	 * @param s is a custom error message 
	 */
	public UnknownGenreException(String s) {
		super(s);
	}
}
