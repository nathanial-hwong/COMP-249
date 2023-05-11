// -----------------------------------------------------
// Assignment 2
// Part: 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
import WheeledTransportation.*;
import Train_Tram.*;
import Monowheel.*;
import Metro.*;
import Ferry.*;
import Aircrafts.*;
/**
 * The A2 class implements all the classes in the A2 project and all the methods they contain to test their validity.
 * It also implements the findLeastAndMostExpensiveAircraft() method.
 * 
 * @author Natha
 *
 */

public class A2 {
	/**
	 * This is driver method "main".
	 * 
	 * @param args ?
	 */
	public static void main(String[] args) {
		//Create object array and fill the array with various vehicular objects
		Object[] vehicles = new Object[16];
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
		//test toString() method
		System.out.println("Displaying all objects information...\n");
		for (int i = 0;i<vehicles.length;i++)
			System.out.println(vehicles[i].toString()+"\n------------------------------------------------------");
		//test equals() method
		System.out.println("Verifying validity of equals() method...\n");
		System.out.println("\n"+vehicles[0].equals(vehicles[2]));
		System.out.println(vehicles[6].equals(vehicles[7]));
		System.out.println(vehicles[4].equals(vehicles[5]));
		//create Array of objects with various objects
		Object[] vehicles2 = new Object[16];
		vehicles2[0] = new WheeledTransportation();
		vehicles2[2] = new Train();
		vehicles2[4] = new Metro();
		vehicles2[6] = new Tram();
		vehicles2[9] = new Monowheel();
		vehicles2[10] = new Ferry();
		vehicles2[1] = new Aircraft(Math.random(),Math.random());
		vehicles2[3] = new Aircraft(Math.random(),Math.random());
		vehicles2[5] = new Aircraft(Math.random(),Math.random());
		vehicles2[7] = new WWIIAirplane(Math.random(),Math.random(),false);
		vehicles2[8] = new WWIIAirplane(Math.random(),Math.random(),true);
		vehicles2[11] = new WWIIAirplane(Math.random(),Math.random(),false);
		vehicles2[12] = new Aircraft(100,2000);
		vehicles2[13] = new Aircraft(Math.random(),Math.random());
		vehicles2[14] = new WWIIAirplane(Math.random(),Math.random(),true);
		vehicles2[15] = new WWIIAirplane(Math.random(),Math.random(),false);
		//create Array of objects without aircraft object
		Object[] vehicles3 = new Object[16];
		vehicles3[0] = new WheeledTransportation();
		vehicles3[1] = new WheeledTransportation(4,100);
		vehicles3[2] = new Train();
		vehicles3[3] = new Train();
		vehicles3[4] = new Metro();
		vehicles3[5] = new Metro(8,80,4,"Montreal","Laval",3);
		vehicles3[6] = new Tram();
		vehicles3[7] = new Tram();
		vehicles3[8] = new Monowheel(1,20,200);
		vehicles3[9] = new Monowheel();
		vehicles3[10] = new Ferry();
		vehicles3[11] = new Ferry();
		vehicles3[12] = new Train();
		vehicles3[13] = new Metro();
		vehicles3[14] = new Tram();
		vehicles3[15] = new Ferry();
		
		//test findLeastAndMostExpensiveAircraft() method
		System.out.println("Finding least and most expensive Aircrafts for 2 arrays...");
		System.out.println("\n"+findLeastAndMostExpensiveAircraft(vehicles2)+"\n----------------------------------");
		System.out.println(findLeastAndMostExpensiveAircraft(vehicles3));
		System.out.println("\nNow exiting the program...");		
	}
	/**
	 * The findLeastAndMostExpensiveAircraft(Object[] vehicles) method takes an array of Objects finds the least and most expensive aircrafts.
	 * @param vehicles is an array that contains various objects of different classes
	 * @return gives the information of the least and most expensive aircraft objects if there are any and returns an error message if not.
	 */
	public static String findLeastAndMostExpensiveAircraft(Object[] vehicles) {
		//declare essential variables
		boolean hasObj = false;
		Aircraft least = null;
		int leastind = -1;
		int mostind = -1;
		Aircraft most = null;
		//find most and least expensive aircrafts
		for(int i = 0; i<vehicles.length; i++) {
			if (vehicles[i] instanceof Aircraft) {
				Aircraft vehicle = (Aircraft)vehicles[i];
				if (hasObj == false) {
					hasObj = true;
					least = (Aircraft)vehicles[i];
					leastind = i;
					most = (Aircraft)vehicles[i];
					mostind = i;
				}
				
				else if (vehicle.getPrice()<least.getPrice()) {
					least = vehicle;
					leastind = i;
				}
				else if (vehicle.getPrice()>most.getPrice()) {
					most = vehicle;
					mostind = i;
				}
				
			}
		}
		//return least/most or return error message
		if(hasObj == false) {
			return ("There are no Aircraft objects in this array.");
		}
		return ("The least expensive aircraft is vehicles["+leastind+"].\n"+least.toString()
				+"\nThe most expensive aircraft is vehicles["+mostind+"].\n"+most.toString());
	}
}
