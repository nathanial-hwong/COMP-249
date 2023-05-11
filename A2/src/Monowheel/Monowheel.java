// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
package Monowheel;
import WheeledTransportation.*;
import Object2.*;
/**
 * The Monowheel class is one the essential classes in the project. It holds values and is the subclass to another object class.
 * @author Natha
 *
 */
public class Monowheel extends WheeledTransportation{
	protected double maxWeight;
	/**
	 * This is the default constructor for the Aircraft class
	 */
	public Monowheel() {
		super();
		this.nbOfWheels = 1;
		this.maxWeight = 100;
	}
	/**
	 * This is the parameterized constructor for the WheeledTransportation class
	 * @param nbOfWheels contains the number of wheels the object has
	 * @param maxSpeed contains the maximum speed of the object
	 * @param maxWeight is the maximum weight the object can hold
	 */
	public Monowheel(int nbOfWheels,double maxSpeed,double maxWeight) {
		super(nbOfWheels,maxSpeed);
		this.maxWeight = maxWeight;
	}
	/**
	 * The copy constructor returns a copy of the object which called the method
	 * @return gives the copy of the object which called the method
	 */
	public Object2 copy() {
		return new Monowheel(nbOfWheels,maxSpeed,maxWeight);
	}
	/**
	 * the getWeight method returns the value of maxWeight
	 * @return gives the value of maxWeight
	 */
	public double getWeight() {
		return maxWeight;
	}
	/**
	 * the toString method returns a string containing all information of the object
	 * @return gives the string containing all information of the object
	 */
	public String toString() {
		return ("This monowheel has "+nbOfWheels+" wheels and has a maximum speed of "+maxSpeed+"."
				+ "It has a max weight of "+maxWeight+".");
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
			Monowheel obj1 = (Monowheel)obj;
			if (this.nbOfWheels != obj1.nbOfWheels)
				return false;
			if (this.maxSpeed != obj1.maxSpeed) 
				return false;
			if (this.maxWeight != obj1.maxWeight) 
				return false;
			else return true;
		
		}
		else return false;
	}
}