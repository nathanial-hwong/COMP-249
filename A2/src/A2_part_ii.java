// -----------------------------------------------------
// Assignment 2
// Part: 2
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
import WheeledTransportation.*;
import Train_Tram.*;
import Monowheel.*;
import Metro.*;
import Ferry.*;
import Aircrafts.*;
import Object2.*;
/**
 * The A2_part_ii class tests the validity of the copyTheObjects() method.
 * @author Natha
 *
 */
public class A2_part_ii {
	/**
	 * This is driver method "main".
	 * 
	 * @param args ?
	 */
	public static void main(String[] args) {
		//create object array and fill with various objcts
		Object2[] vehicles = new Object2[16];
		vehicles[0] = new WheeledTransportation();
		vehicles[1] = new WheeledTransportation(4,100);
		vehicles[2] = new Train();
		vehicles[3] = new Train();
		vehicles[4] = new Metro();
		vehicles[5] = new Metro(8,80,4,"Montreal","Laval",3);
		vehicles[6] = new Tram();
		vehicles[7] = new Tram();
		vehicles[8] = new Monowheel(1,20,200);
		vehicles[9] = new Monowheel();
		vehicles[10] = new Ferry();
		vehicles[11] = new Ferry();
		vehicles[12] = new Aircraft(100,2000);
		vehicles[13] = new Aircraft();
		vehicles[14] = new WWIIAirplane();
		vehicles[15] = new WWIIAirplane();
		//test copyTheObjects() method

		Object2[] vehicles_copy = copyTheObjects(vehicles);
		System.out.println("Checking if all objects are equal...\n");
		for(int i = 0; i<vehicles_copy.length; i++) {
			System.out.println(vehicles[i].equals(vehicles_copy[i]));
		}
		System.out.println("\nNow exiting the program...");

	}
	/**
	 * The copyTheObjects method takes an array of vehicular objects and returns a copy of the array.
	 * @param vehicles is an array of the objects which are to be copied.
	 * @return gives the copied array.
	 */
	public static Object2[] copyTheObjects(Object2[] vehicles) {
		//declare duplicate array skeleton
		Object2[] vehicles_c = new Object2[vehicles.length];
		//fill duplicate array
		for (int i = 0; i<vehicles.length; i++) {
			vehicles_c[i] = vehicles[i].copy();
		}
		return vehicles_c;
	}
}