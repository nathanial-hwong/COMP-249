// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
package Aircrafts;
import Object2.*;
/**
 * The WWIIAircraft class is one the essential classes in the project. It holds values and is the subclass to another object class.
 * @author Natha
 *
 */
public class WWIIAirplane extends Aircraft{
	protected boolean twinEng;
	/**
	 * This is the default constructor for the Aircraft class
	 */
	public WWIIAirplane() {
		super();
		this.twinEng=true;
	}
	/**
	 * This is the parameterized constructor for the WWIIAirplane class
	 * @param price contains the price which is to be assigned to the object
	 * @param maxElevation contains the maximum elevation which is to be assigned to the object
	 * @param twinEng says whether or not the Airplane has a twin engine
	 */
	public WWIIAirplane(double price,double maxElevation,boolean twinEng) {
		super(price,maxElevation);
		this.twinEng = twinEng;
	}
	/**
	 * The copy constructor returns a copy of the object which called the method
	 * @return gives the copy of the object which called the method
	 */
	public Object2 copy() {
		return new WWIIAirplane(price,maxElevation,twinEng);
	}
	/**
	 * the getEng method returns the value of twinEng
	 * @return gives the value of twinEng
	 */
	public boolean getEng() {
		return twinEng;
	}
	/**
	 * the toString method returns a string containing all information of the object
	 * @return gives the string containing all information of the object
	 */
	public String toString() {
		if (twinEng==true) {
			return ("This aircraft has a price of "+price+" and a max elevation of "+maxElevation+"."
					+ "It has a twin engine");
		}
		else {
			return ("This aircraft has a price of "+price+" and a max elevation of "+maxElevation+"."
					+ "It does not have a twin engine");
		}
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
			WWIIAirplane obj1 = (WWIIAirplane)obj;
			if (this.price != obj1.price)
				return false;
			if (this.maxElevation != obj1.maxElevation) 
				return false;
			if (this.twinEng != obj1.twinEng)
				return false;
			else return true;

				
		
		}
		else return false;
	}
}
