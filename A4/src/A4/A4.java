// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 4
// Due Monday April 17 2023
// -----------------------------------------------------
package A4;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * The A4 class is the class which contains the driver method.
 * @author Natha
 *
 */
public class A4 {
	/**
	 * The main method reads book entries and sorts them.
	 * @param args command line arguments.
	 */
	public static void main(String[] args) {
		//initialize required data
		ArrayList<String> arrLst = new ArrayList<String>();
		BookList bkLst = new BookList();
		Scanner s = null;
		
		//read through all book entries, and sort them by valid and invalid year entry
		try {
			s = new Scanner(new FileInputStream("Books.txt"));
		}
		catch(IOException e) {
			System.out.println("Error reading Books.txt file...");
		}
		while (s.hasNextLine()) {
			String bookEntry = s.nextLine();
			String[] book = bookEntry.split(",");
			
			if(Integer.parseInt(book[5])>2023) {
				arrLst.add(bookEntry);
			}
			else {
				bkLst.addToStart(new Book(book[0],book[1],Double.parseDouble(book[2]),Long.parseLong(book[3]),book[4],Integer.parseInt(book[5])));
			}
		}
		bkLst = bkLst.reverseList();
		
		//output invalid entries to YearErr.txt
		PrintWriter p = null;
		try {
			p = new PrintWriter(new FileOutputStream("YearErr.txt"));
		}
		catch(IOException e) {
			System.out.println("Error writing file.");
		}
		for(int i = 0; i<arrLst.size();i++) {
			p.println(arrLst.get(i));
		}
		p.close();
		bkLst.displayContent();
		System.out.println("========================================\n\n");
		//initializes all required variables
		Scanner obj = new Scanner(System.in);
		String choice;
		int ch;
		boolean display = true;
		String isbnChoice;
		Long isbnChoice1;
		Long isbnChoice2;
		Book b;
		BookList tempList;
		boolean valid;
		//start of menu
		while(display) {
			System.out.println("\n---------------------------------------\n"
					+ "1) Give me a year # and I would extract all records of that year and store them in a file for that year;\n"
					+ "2) Ask me to delete all consecutive repeated records;\n"
					+ "3) Give me an author name and I will create a new list with the records of this author and display them;\n"
					+ "4) Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN;\n"
					+ "5) Give me 2 ISBN numbers and a Book object, and I will insert a Node between them, if I find them!\n"
					+ "6) Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records; of course if they exist!\n"
					+ "7) Tell me to COMMIT! Your command is my wish. I will commit your list to a file called Updated_Books;\n"
					+ "8) Tell me to STOP TALKING. Remember, if you do not commit, I will not!\n"
					+ "---------------------------------------\n");
			System.out.print("Please enter an integer : ");
			choice = obj.nextLine();
			while(!isInt(choice)||Integer.parseInt(choice)>8||Integer.parseInt(choice)<1) {
				System.out.println("Entry invalid, please try again : ");
				choice = obj.nextLine();
			}
			ch = Integer.parseInt(choice);
			switch(ch) {
			
			case 1:
				System.out.print("Please enter the publishing year of your choice : ");
				choice = obj.nextLine();
				while(!isInt(choice)||Integer.parseInt(choice)>2024||Integer.parseInt(choice)<1905) {
					System.out.print("Entry invalid, please try again : ");
					choice = obj.nextLine();
				}
				bkLst.storeRecordByYear(Integer.parseInt(choice));
				break;
				
			case 2:
				if(bkLst.delConsecutiveRepeatedRecords())
					System.out.println("Success");
				else 
					System.out.println("No entries found.");
				break;
				
			case 3:
				System.out.print("Please enter the author of your choice : ");
				choice = obj.nextLine();
				tempList = bkLst.extractAuthList(choice);
				if(tempList.size()==0)
					System.out.println("No authors found");
				else {
					tempList.displayContent();
				}
				break;
				
			case 4:
				System.out.print("Please enter the ISBN : ");
				isbnChoice = obj.nextLine();
				while(!isLong(isbnChoice)) {
					System.out.print("Entry invalid, please try again : ");
					isbnChoice = obj.nextLine();
				}
				isbnChoice1 = Long.parseLong(isbnChoice);
				System.out.print("Please enter a book entry : ");
				valid = false;
				do {
					String[] book = obj.nextLine().split(",");
					try {
						b = new Book(book[0],book[1],Double.parseDouble(book[2]),Long.parseLong(book[3]),book[4],Integer.parseInt(book[5]));
						if(bkLst.insertBefore(isbnChoice1,b))
							System.out.println("Success");
						else 
							System.out.println("Entries not found.");
						valid = true;
					}
					catch(Exception e){
						System.out.print("Entry invalid, please try again : ");
					}
				}while(!valid);
				break;
				
			case 5:
				System.out.print("Please enter the first ISBN : ");
				isbnChoice = obj.nextLine();
				while(!isLong(isbnChoice)) {
					System.out.print("Entry invalid, please try again : ");
					isbnChoice = obj.nextLine();
				}
				isbnChoice1 = Long.parseLong(isbnChoice);
				System.out.print("Please enter the second ISBN : ");
				isbnChoice = obj.nextLine();
				while(!isLong(isbnChoice)) {
					System.out.print("Entry invalid, please try again : ");
					isbnChoice = obj.nextLine();
				}
				isbnChoice2 = Long.parseLong(isbnChoice);
				System.out.print("Please enter a book entry : ");
				valid = false;
				do {
					String[] book = obj.nextLine().split(",");
					try {
						b = new Book(book[0],book[1],Double.parseDouble(book[2]),Long.parseLong(book[3]),book[4],Integer.parseInt(book[5]));
						if(bkLst.insertBetween(isbnChoice1,isbnChoice2,b))
							System.out.println("Success");
						else 
							System.out.println("Error inserting entry.");
						valid = true;
					}
					catch(Exception e){
						System.out.print("Entry invalid, please try again : ");
					}
				}while(!valid);
				break;
				
			case 6:
				System.out.print("Please enter the first ISBN : ");
				isbnChoice = obj.nextLine();
				while(!isLong(isbnChoice)) {
					System.out.print("Entry invalid, please try again : ");
					isbnChoice = obj.nextLine();
				}
				isbnChoice1 = Long.parseLong(isbnChoice);
				System.out.print("Please enter the second ISBN : ");
				isbnChoice = obj.nextLine();
				while(!isLong(isbnChoice)) {
					System.out.print("Entry invalid, please try again : ");
					isbnChoice = obj.nextLine();
				}
				isbnChoice2 = Long.parseLong(isbnChoice);
				if(bkLst.swap(isbnChoice1,isbnChoice2))
					System.out.println("Success");
				else 
					System.out.println("Entries not found.");
				break;
				
			case 7:
				bkLst.commit();
				System.out.println("Done writing to file.");
				break;
				
			case 8:
				display = false;
				System.out.println("Now exiting program...");
				break;
			}
		}
	}
	/**
	 * The isInt method verifies whether the string given can be converted to an integer.
	 * @param c is the string to be checked.
	 * @return gives the boolean which is the result of the verification
	 */
	public static boolean isInt(String c) {
		int choice;
		try {
			choice = Integer.parseInt(c);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * The isLong method verifies whether the string given can be converted to a Long.
	 * @param c is the string to be checked.
	 * @return gives the boolean which is the result of the verification
	 */
	public static boolean isLong(String c) {
		Long choice;
		try {
			choice = Long.parseLong(c);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
}
