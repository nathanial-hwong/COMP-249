// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
package Aircrafts;
import Object2.*;

/**
 * The Aircraft class is one the essential classes in the project. It holds values and is the superclass to another object class.
 * @author Natha
 *
 */
public class Aircraft extends Object2{
	protected double price;
	protected double maxElevation;
	/**
	 * This is the default constructor for the Aircraft class
	 */
	public Aircraft() {
		price = 10;
		maxElevation = 1000;
	}
	/**
	 * This is the parameterized constructor for the Aircraft class
	 * @param price contains the price which is to be assigned to the object
	 * @param maxElevation contains the maximum elevation which is to be assigned to the object
	 */
	public Aircraft(double price,double maxElevation) {
		this.price=price;
		this.maxElevation = maxElevation;
	}
	/**
	 * The copy constructor returns a copy of the object which called the method
	 * @return gives the copy of the object which called the method
	 */
	public Object2 copy() {
		return new Aircraft(price,maxElevation);
	}
	/**
	 * the getPrice method returns the value of price
	 * @return gives the value of price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * the getElevation method returns the value of maxElevation
	 * @return gives the value of maxElevation
	 */
	public double getElevation() {
		return maxElevation;
	}
	/**
	 * the toString method returns a string containing all information of the object
	 * @return gives the string containing all information of the object
	 */
	public String toString() {
		return ("This aircraft has a price of "+price+" and a max elevation of "+maxElevation+".");
	}
	/**
	 * The equals method checks if 2 aircraft objects are the same
	 * @param obj is the object that is to be compared to the one that called the method
	 */
	public boolean equals(Object obj) {

		if (obj==null) {
			return false;
		}
		else if (obj.getClass()==this.getClass()) {
			Aircraft obj1 = (Aircraft)obj;
			if (this.price != obj1.price)
				return false;
			if (this.maxElevation != obj1.maxElevation) 
				return false;
			else return true;
				
		
		}
		else return false;

	}
}
