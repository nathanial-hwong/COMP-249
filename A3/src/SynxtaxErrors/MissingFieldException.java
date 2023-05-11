// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// -----------------------------------------------------
package SynxtaxErrors;

/**
 * MissingFieldException class creates a new Exception
 * @author Natha
 *
 */
public class MissingFieldException extends Exception{
	protected static String[] field = {"title","authors","price","isbn","genre","year"};
	/**
	 * Default constructor for MissingFieldException class.
	 */
	public MissingFieldException() {
		super("Error: missing field(s) ");
	}
	/**
	 * Parameterized constructor which takes a string.
	 * @param s is a custom error message 
	 */
	public MissingFieldException(String s) {
		super(s);
	}
	/**
	 * Parameterized constructor which takes an integer and gives the field which is problematic.
	 * @param i is the index of the field which is problematic.
	 */
	public MissingFieldException(int i) {
		super("missing "+field[i]);
	}
}
