// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
package Train_Tram;
import Metro.Metro;
import Object2.*;
/**
 * The Tram class is one the essential classes in the project. It holds values and is the subclass to another object class.
 * @author Natha
 *
 */
public class Tram extends Metro{
	protected int creationYr;
	/**
	 * This is the default constructor for the Aircraft class
	 */
	public Tram() {
		super();
		this.creationYr = 2000;
	}
	/**
	 * This is the parameterized constructor for the WheeledTransportation class
	 * @param nbOfWheels contains the number of wheels the object has
	 * @param maxSpeed contains the maximum speed of the object
	 * @param nbVehicles is the number of vehicles the train has
	 * @param startStation is the starting station of the train
	 * @param destStation is the destination station of the train
	 * @param nbStops is the number of stop the tram will make
	 * @param creationYr is the year the tram was made
	 */
	public Tram(int nbOfWheels,double maxSpeed,int nbVehicles,String startStation,String destStation,int nbStops,int creationYr) {
		super(nbOfWheels,maxSpeed,nbVehicles,startStation,destStation,nbStops);
		this.creationYr = creationYr;
	}
	/**
	 * The copy constructor returns a copy of the object which called the method
	 * @return gives the copy of the object which called the method
	 */
	public Object2 copy() {
		return new Tram(nbOfWheels,maxSpeed,nbVehicles,startStation,destStation,nbStops,creationYr);
	}
	/**
	 * the getCreat method returns the value of creationYr
	 * @return gives the value of creationYr
	 */
	public int getCreat() {
		return creationYr;
	}
	/**
	 * the toString method returns a string containing all information of the object
	 * @return gives the string containing all information of the object
	 */
	public String toString() {
		return ("This tram has "+nbOfWheels+" wheels and has a max speed of "+maxSpeed+". "
				+ "\nIt has "+nbVehicles+" vehicles and its starting and destination stations are "+startStation+" and "+destStation+"."
				+ "\nIt has "+nbStops+" stops."
				+ "\nThe creation year of this tram is "+creationYr+".");
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
			Tram obj1 = (Tram)obj;
			if (this.nbOfWheels != obj1.nbOfWheels)
				return false;
			if (this.maxSpeed != obj1.maxSpeed) 
				return false;
			if (this.nbVehicles != obj1.nbVehicles)
				return false;
			if (this.startStation != obj1.startStation)
				return false;
			if (this.destStation != obj1.destStation)
				return false;
			if (this.nbStops != obj1.nbStops)
				return false;
			if (this.creationYr != obj1.creationYr)
				return false;
			else return true;
				
		
		}
		else return false;
	}
}
