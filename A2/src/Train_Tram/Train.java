// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
package Train_Tram;
import WheeledTransportation.WheeledTransportation;
import Object2.*;
/**
 * The Train class is one the essential classes in the project. It holds values and is the subclass to another object class.
 * @author Natha
 *
 */
public class Train extends WheeledTransportation{
	protected int nbVehicles;
	protected String startStation;
	protected String destStation;
	/**
	 * This is the default constructor for the Aircraft class
	 */
	public Train() {
		super();
		this.nbVehicles = 2;
	}
	/**
	 * This is the parameterized constructor for the WheeledTransportation class
	 * @param nbOfWheels contains the number of wheels the object has
	 * @param maxSpeed contains the maximum speed of the object
	 * @param nbVehicles is the number of vehicles the train has
	 * @param startStation is the starting station of the train
	 * @param destStation is the destination station of the train
	 */
	public Train(int nbOfWheels,double maxSpeed,int nbVehicles,String startStation,String destStation) {
		super(nbOfWheels,maxSpeed);
		this.nbVehicles = nbVehicles;
		this.startStation = startStation;
		this.destStation = destStation;
	}
	/**
	 * The copy constructor returns a copy of the object which called the method
	 * @return gives the copy of the object which called the method
	 */
	public Object2 copy() {
		return new Train(nbOfWheels,maxSpeed,nbVehicles,startStation,destStation);
		
	}
	/**
	 * the getVehicles method returns the value of nbVehicles
	 * @return gives the value of nbVehicles
	 */
	public int getVehicles() {
		return nbVehicles;
	}
	/**
	 * the getStation method returns the value of startStation
	 * @return gives the value of startStation
	 */
	public String getStart() {
		return startStation;
	}
	/**
	 * the getDest method returns the value of destStation
	 * @return gives the value of destStation
	 */
	public String getDest() {
		return destStation;
	}
	/**
	 * the toString method returns a string containing all information of the object
	 * @return gives the string containing all information of the object
	 */
	public String toString() {
		return ("This train has "+nbOfWheels+" wheels and has a max speed of "+maxSpeed+". "
				+ "It has "+nbVehicles+" vehicles and its starting and destination stations are "+startStation+" and "+destStation);
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
			Train obj1 = (Train)obj;
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
			else return true;
				
		
		}
		else return false;
		
	}
}
