// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// -----------------------------------------------------
//My program reads files that contain book entries. It sorts through the books and puts aside invalid entries and outputs
//files containing the books sorted by genre. It then serves as a menu to navigate through the valid books file by file.
package A3;
/**
 * The A3 class is the class which contains the driver method.
 * @author Natha
 *
 */
public class A3 {
	/**
	 * The main method implements methods from classes part1, part2, and part 3
	 * @param args command line arguments.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Nathanial's book data reader!");
		part1 p1 = new part1();
		part2 p2 = new part2();
		part3 p3 = new part3();
		p1.do_part1();
		p2.do_part2();
		p3.do_part3();
		
		
	}

}
