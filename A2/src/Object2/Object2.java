// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
package Object2;

/**
 * The object2 abstract class is a superclass to all other classes used.
 * It lets the driver class run the copy constructor without having to know the class of the object to be copied.
 * @author Natha
 * 
 */
public abstract class Object2 {

	/**
	 * The abstract class copy() allows the copy() constructor to be called without knowing the type of the object to be copied.
	 * @return does not return anything as it is an abstract class
	 */
	public abstract Object2 copy();
}
