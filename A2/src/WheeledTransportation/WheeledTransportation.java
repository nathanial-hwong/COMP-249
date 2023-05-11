// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
package WheeledTransportation;
import Object2.*;
/**
 * The WheeledTransportation class is one the essential classes in the project. It holds values and is the superclass to other object classes.
 * @author Natha
 *
 */
public class WheeledTransportation extends Object2{
	protected int nbOfWheels;
	protected double maxSpeed;
	/**
	 * This is the default constructor for the Aircraft class
	 */
	public WheeledTransportation() {
		nbOfWheels = 4;
		maxSpeed = 100;
	}
	/**
	 * This is the parameterized constructor for the WheeledTransportation class
	 * @param nbOfWheels contains the number of wheels the object has
	 * @param maxSpeed contains the maximum speed of the object
	 */
	public WheeledTransportation(int nbOfWheels,double maxSpeed) {
		this.nbOfWheels = nbOfWheels;
		this.maxSpeed = maxSpeed;
	}
	/**
	 * The copy constructor returns a copy of the object which called the method
	 * @return gives the copy of the object which called the method
	 */
	public Object2 copy() {
		return new WheeledTransportation(this.nbOfWheels,this.maxSpeed);
	}
	/**
	 * the getWheels method returns the value of nbOfWheels
	 * @return gives the value of nbOfWheels
	 */
	public int getWheels() {
		return nbOfWheels;
	}
	/**
	 * the getSpeed method returns the value of maxSpeed
	 * @return gives the value of maxSpeed
	 */
	public double getSpeed() {
		return maxSpeed;
	}
	/**
	 * the toString method returns a string containing all information of the object
	 * @return gives the string containing all information of the object
	 */
	public String toString() {
		return ("This wheeled transportation has "+nbOfWheels+" wheels and has a maximum speed of "+maxSpeed+".");
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
			WheeledTransportation obj1 = (WheeledTransportation)obj;
			if (this.nbOfWheels != obj1.nbOfWheels)
				return false;
			if (this.maxSpeed != obj1.maxSpeed) 
				return false;
			else
				return true;
				
		
		}
		else return false;

	}
}
