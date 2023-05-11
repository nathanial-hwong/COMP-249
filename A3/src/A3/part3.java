// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// Question: Part 3 of 3
// -----------------------------------------------------
package A3;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.Scanner;
/**
 * part3 defines methods necessary to read book objects from bin files and display 
 * an interactive menu to navigate book information from bin files.
 * @author Natha
 *
 */
public class part3 {
	protected Book[] books = new Book[1];
	protected Book[][] sortedBooks = new Book[8][1];
	protected String[] file_genres = {"CCB","HCB","MTV","MRB","NEB","OTR","SSM","TPA"};
	protected String[] files = {"Cartoons_Comics_Books.csv.ser.bin","Hobbies_Collectibles_Books.csv.ser.bin","Movies_TV.csv.ser.bin","Music_Radio_Books.csv.ser.bin","Nostalgia_Eclectic_Books.csv.ser.bin","Old_Time_Radio.csv.ser.bin","Sports_Sports_Memorabilia.csv.ser.bin","Trains_Planes_Automobiles.csv.ser.bin"};
	/**
	 * do_part3 implements other methods in its class to get and display a Book objects menu.
	 */
	public void do_part3() {
		get__and_sort_books();
		display();
	}
	/**
	 * get_and_sort_books reads book objects from multiple files and sorts them by file.
	 */
	public void get__and_sort_books() {
		ObjectInputStream ccb = null;
		ObjectInputStream hcb = null; 
		ObjectInputStream mtv = null; 
		ObjectInputStream mrb = null; 
		ObjectInputStream neb = null; 
		ObjectInputStream otr = null; 
		ObjectInputStream ssm = null; 
		ObjectInputStream tpa = null;
		try { 
			ccb = new ObjectInputStream(new FileInputStream("Cartoons_Comics_Books.csv.ser.bin"));
			hcb = new ObjectInputStream(new FileInputStream("Hobbies_Collectibles_Books.csv.ser.bin"));
			mtv = new ObjectInputStream(new FileInputStream("Movies_TV.csv.ser.bin"));
			mrb = new ObjectInputStream(new FileInputStream("Music_Radio_Books.csv.ser.bin"));
			neb = new ObjectInputStream(new FileInputStream("Nostalgia_Eclectic_Books.csv.ser.bin"));
			otr = new ObjectInputStream(new FileInputStream("Old_Time_Radio.csv.ser.bin"));
			ssm = new ObjectInputStream(new FileInputStream("Sports_Sports_Memorabilia.csv.ser.bin"));
			tpa = new ObjectInputStream(new FileInputStream("Trains_Planes_Automobiles.csv.ser.bin"));
			ObjectInputStream[] input_files = {ccb,hcb,mtv,mrb,neb,otr,ssm,tpa};
			for (int i = 0;i<input_files.length;i++) {
				boolean empty = false;
				while (!empty) {
					try {
						books[books.length-1]=(Book)input_files[i].readObject();
						books = increase_array(books);
					}
					catch(ClassNotFoundException e) {
						System.out.println("Error reading object, skipping file");
						break;
					}
					catch(IOException e) {
						empty = true;
					}
				}
			}
			ccb.close();
			hcb.close();
			mtv.close();
			mrb.close();
			neb.close();
			otr.close();
			ssm.close();
			tpa.close();
		}
		catch(IOException e) {
			System.out.println("Error reading from file");
		}
		for (int i = 0;i<books.length-1;i++) {
			for (int k = 0;k<file_genres.length;k++) {
				if((books[i].getGenre()).equals(file_genres[k])) {
					sortedBooks[k][sortedBooks[k].length-1]=new Book(books[i]);
					sortedBooks = increase_array(sortedBooks,k);
					break;
				}
			}
		}
	}
	/**
	 * display creates an interactive menu that can be used to access information of the book objects read from the files.
	 */
	public void display() {
		int file = 0;
		String option = "";
		Scanner obj = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			System.out.print("\n\n-----------------------------"
					 + "\n          Main Menu"
					 + "\n-----------------------------"
					 + "\n v  View the selected file: "+files[file]+" ("+(sortedBooks[file].length-1)+" records)"
					 + "\n s  Select a file to view"
					 + "\n x  Exit"
					 + "\n-----------------------------"
					 + "\n\nEnter Your Choice: ");
			option = obj.next().trim().toLowerCase();
			if (option.equals("x")) {
				System.out.println("Now exiting program...");
				exit = true;
				continue;
			}
			else if (option.equals("s")) {
				System.out.println("\n\n-----------------------------"
					      + "\n        File Sub-Menu"
					      + "\n-----------------------------");
				for(int i = 0; i<files.length;i++) {
					int records = sortedBooks[i].length-1;
					System.out.printf("%-3s %-40s (%s records)%n",i+1,files[i],records,"records");
				}
				System.out.print("9   Exit"
				 + "\n-----------------------------"
				 + "\n\nEnter Your Choice: ");
				option = obj.next();
				boolean valid = true;
				do {
					if(isInt(option)) {
						if (Integer.parseInt(option)==9) {
							exit = true;
							break;
						}
						else if(Integer.parseInt(option)>0&&Integer.parseInt(option)<9) {
							file = Integer.parseInt(option)-1;
							continue;
						}
						else {
							System.out.println("invalid input, try again: ");
							option = obj.next();
							valid = false;
							continue;
						}
					}
					else {
						System.out.println("invalid input, try again: ");
						option = obj.next();
						valid = false;
						continue;
					}
					
				}
				while (!valid);
				
			}
			else if (option.equals("v")) {
				System.out.println("viewing: "+files[file]+" ("+(sortedBooks[file].length-1)+" records)");
				view(file);
			}
		}
		
	}
	/**
	 * view displays the sub menu used to navigate the book information contained in a file.
	 * @param file is an integer that represents the file whose books the user wants to view.
	 */
	public void view(int file) {
		int oldpointer = 0;
		int newpointer = 0;
		Scanner obj = new Scanner(System.in);
		int next=1;
		boolean viewing = true;
		while(viewing) {
			System.out.println("-----------------------------"
					+ "\nPlease enter any integer to navigate (enter 0 to change file): ");
			next = obj.nextInt();
			if(next==0) {
				viewing=false;
				continue;
			}
			else {
				oldpointer = newpointer;
				newpointer = oldpointer+shift(next,oldpointer,file);
				System.out.println("-----------------------------");
				if(oldpointer<=newpointer)
					for(int i = oldpointer;i<=newpointer;i++) {
						System.out.println(sortedBooks[file][i].getTitle()+","+sortedBooks[file][i].getAuthor()+","+sortedBooks[file][i].getPrice()+","+sortedBooks[file][i].getIsbn()+","+sortedBooks[file][i].getGenre()+","+sortedBooks[file][i].getYear());
					}
				else if (oldpointer>newpointer) {
					for(int i = newpointer;i<=oldpointer;i++) {
						System.out.println(sortedBooks[file][i].getTitle()+","+sortedBooks[file][i].getAuthor()+","+sortedBooks[file][i].getPrice()+","+sortedBooks[file][i].getIsbn()+","+sortedBooks[file][i].getGenre()+","+sortedBooks[file][i].getYear());
					}
				}
			}
		}
	}
	/**
	 * shift takes an integer input and gives the movement the pointer has to make.
	 * @param num is the integer value given by the user
	 * @param oldpointer is the position where the pointer currently is
	 * @param file is an integer that represents the file the pointer is navigating.
	 * @return gives an integer which is the movement the pointer will make.
	 */
	public int shift(int num,int oldpointer,int file) {
		if (num<0) {
			if (oldpointer+num-1<0)
				return oldpointer*(-1);
			return num+1;
		}
		else {
			if (oldpointer+num+1>sortedBooks[file].length-2)
				return (sortedBooks[file].length-oldpointer-2);
			return num-1;
		}
		
	}
	/**
	 * The increase_array method increases the size of a Book array.
	 * @param books contains the array that is to be increased.
	 * @return gives the array that has been increased in size.
	 */
	public Book[] increase_array(Book[] books) {
		Book[] temp = new Book[books.length+1];
		for(int i = 0;i<books.length;i++) {
			temp[i] = new Book(books[i]);
		}
		return temp;
	}
	/**
	 * The increase_array method increases the number of columns of a specified row in a 2d Book array.
	 * @param sortedBooks contains the array that is to be increased.
	 * @param genre contains the row whose columns will be increased.
	 * @return gives the array that has been increased in size.
	 */
	public Book[][] increase_array(Book[][] sortedBooks,int genre) {
		Book[] temp = new Book[sortedBooks[genre].length+1];
		for(int i = 0;i<sortedBooks[genre].length;i++) {
			temp[i]=new Book(sortedBooks[genre][i]);
		}
		
		sortedBooks[genre]=temp;
		return sortedBooks;
	}
	/**
	 * isInt method returns whether or not a String contains a Integer value
	 * @param str is the string to be checked.
	 * @return gives a boolean which is the result of the verification.
	 */
	public boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
