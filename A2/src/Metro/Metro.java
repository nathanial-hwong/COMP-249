// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
package Metro;
import Train_Tram.Train;
import Object2.*;
/**
 * The Metro class is one the essential classes in the project. It holds values and is the subclass to another object class.
 * @author Natha
 *
 */
public class Metro extends Train{
	protected int nbStops;
	/**
	 * This is the default constructor for the Aircraft class
	 */
	public Metro() {
		super();
		nbStops = 1;
	}
	/**
	 * This is the parameterized constructor for the WheeledTransportation class
	 * @param nbOfWheels contains the number of wheels the object has
	 * @param maxSpeed contains the maximum speed of the object
	 * @param nbVehicles is the number of vehicles the train has
	 * @param startStation is the starting station of the train
	 * @param destStation is the destination station of the train
	 * @param nbStops is the number of stop the tram will make
	*/
	public Metro(int nbOfWheels,double maxSpeed,int nbVehicles,String startStation,String destStation,int nbStops) {
		super(nbOfWheels,maxSpeed,nbVehicles,startStation,destStation);
		this.nbStops = nbStops;
	}
	/**
	 * The copy constructor returns a copy of the object which called the method
	 * @return gives the copy of the object which called the method
	 */
	public Object2 copy() {
		return new Metro(nbOfWheels,maxSpeed,nbVehicles,startStation,destStation,nbStops);
	}
	/**
	 * the getStops method returns the value of nbStops
	 * @return gives the value of nbStops
	 */
	public int getStops() {
		return nbStops;
	}
	/**
	 * the toString method returns a string containing all information of the object
	 * @return gives the string containing all information of the object
	 */
	public String toString() {
		return ("This metro has "+nbOfWheels+" wheels and has a max speed of "+maxSpeed+". "
				+ "\nIt has "+nbVehicles+" vehicles and its starting and destination stations are "+startStation+" and "+destStation
				+ "\nIt has "+nbStops+" stops.");
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
			Metro obj1 = (Metro)obj;
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
			else return true;
		
		}
		else return false;

	}
}
