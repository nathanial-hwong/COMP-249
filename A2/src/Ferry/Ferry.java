// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
package Ferry;
import Object2.*;
/**
 * The Ferry class is one the essential classes in the project. It holds multiple values.
 * @author Natha
 *
 */
public class Ferry extends Object2{
	protected double maxSpeed;
	protected double maxLoad;
	/**
	 * This is the default constructor for the Aircraft class
	 */
	public Ferry(){
		
	}
	/**
	 * This is the parameterized constructor for the Aircraft class
	 * @param maxSpeed contains the maximum speed of the object
	 * @param maxLoad contains the maximum load which the object can hold
	 */
	public Ferry(double maxSpeed,double maxLoad) {
		this.maxSpeed = maxSpeed;
		this.maxLoad = maxLoad;
	}
	/**
	 * The copy constructor returns a copy of the object which called the method
	 * @return gives the copy of the object which called the method
	 */
	public Object2 copy() {
		return new Ferry(maxSpeed,maxLoad);
	}
	/**
	 * the getSpeed method returns the value of maxSpeed
	 * @return gives the value of maxSpeed
	 */
	public double getSpeed() {
		return maxSpeed;
	}
	/**
	 * the getLoad method returns the value of maxLoad
	 * @return gives the value of maxLoad
	 */
	public double getLoad() {
		return maxLoad;
	}
	/**
	 * the toString method returns a string containing all information of the object
	 * @return gives the string containing all information of the object
	 */
	public String toString() {
		return ("This ferry has a max speed of "+maxSpeed+" and a max load of "+maxLoad+".");
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
			Ferry obj1 = (Ferry)obj;
			if (this.maxLoad != obj1.maxLoad)
				return false;
			if (this.maxSpeed != obj1.maxSpeed) 
				return false;
			else return true;
				
		
		}
		else return false;
	}
}
