// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// Question: Part 2 of 3
// -----------------------------------------------------
package A3;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import SemanticErrors.*;
/**
 * part2 class defines methods necessary to read files containing book information and processing the information
 * This class removes books with invalid isbns, invalid prices, and invalid years.
 * @author Natha
 *
 */
public class part2 {
	
	protected String[][] books = new String[0][7];
	protected Book[] book_objs = new Book[0];
	protected String[] file_genres = {"CCB","HCB","MTV","MRB","NEB","OTR","SSM","TPA"};
	protected int[] books_per_genre = new int[file_genres.length];
	
	/**
	 * The do_part2 method implements other methods in the class to create the proper output files.
	 */
	public void do_part2() {
		String[] files = getFiles("part2_input_file_names.txt");
		for(int i = 0;i<files.length;i++) {
			readBooksFile(files[i]);
		}
		validate_and_sort();
		output_books();
	}
	/**
	 * The getFiles reads a file and saves the names of files found in that file.
	 * @param list is the name of the input file to be read.
	 * @return gives an array of file names that contain information on books.
	 */
	public String[] getFiles(String list) {
		String[] files = new String[0];
		Scanner s = null;
		try {
			s = new Scanner(new FileInputStream(list));
			int numFiles = s.nextInt();
			s.nextLine();
			for(int i = 0;i<numFiles;i++) {
				files = increase_array(files);
				files[i] = s.nextLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error getting file names");
			return null;
		}
		return files;
	}
	/**
	 * The readBooksFile method takes a file name and reads all book information containe in the file.
	 * @param file_name is the name of the file to be read.
	 * @return gives a string which confirms whether or not the method was successful.
	 */
	public String readBooksFile(String file_name) {
		Scanner s = null;
		try {
			s = new Scanner(new FileInputStream(file_name));
		}
		catch(IOException e) {
			System.out.println("Error reading "+file_name);
			return ("Error, terminated method");
		}
		while(s.hasNextLine()) {
			String temp = s.nextLine();
			String[] str = process_string(temp,file_name);
			books = increase_array(books);
			for (int i=0;i<str.length;i++) {
				books[books.length-1][i]=str[i];
			}
		}
		s.close();
		return("done reading file");
	}
	/**
	 * The method output_books writes the sorted Book objects onto the output files.
	 */
	public void output_books() {
		ObjectOutputStream ccb = null;
		ObjectOutputStream hcb = null; 
		ObjectOutputStream mtv = null; 
		ObjectOutputStream mrb = null; 
		ObjectOutputStream neb = null; 
		ObjectOutputStream otr = null; 
		ObjectOutputStream ssm = null; 
		ObjectOutputStream tpa = null;
		try { 
			ccb = new ObjectOutputStream(new FileOutputStream("Cartoons_Comics_Books.csv.ser.bin"));
			hcb = new ObjectOutputStream(new FileOutputStream("Hobbies_Collectibles_Books.csv.ser.bin"));
			mtv = new ObjectOutputStream(new FileOutputStream("Movies_TV.csv.ser.bin"));
			mrb = new ObjectOutputStream(new FileOutputStream("Music_Radio_Books.csv.ser.bin"));
			neb = new ObjectOutputStream(new FileOutputStream("Nostalgia_Eclectic_Books.csv.ser.bin"));
			otr = new ObjectOutputStream(new FileOutputStream("Old_Time_Radio.csv.ser.bin"));
			ssm = new ObjectOutputStream(new FileOutputStream("Sports_Sports_Memorabilia.csv.ser.bin"));
			tpa = new ObjectOutputStream(new FileOutputStream("Trains_Planes_Automobiles.csv.ser.bin"));
			ObjectOutputStream[] output_files = {ccb,hcb,mtv,mrb,neb,otr,ssm,tpa};
			for (int i = 0;i<book_objs.length;i++) {
				for (int k = 0;k<file_genres.length;k++) {
					if((books[i][5].trim()).equals(file_genres[k])) {
						books_per_genre[k]++;
						output_files[k].writeObject(book_objs[i]);
						break;
					}
				}
			}
			ccb.flush();
			hcb.flush();
			mtv.flush();
			mrb.flush();
			neb.flush();
			otr.flush();
			ssm.flush();
			tpa.flush();
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
			System.out.println("Error writing to file");
		}
		
	}
	/**
	 * The validate and sort method goes through the books array and sorts the books found in it.
	 * It then sorts and writes valid books into their files by genre and writes invalid books to the error file.
	 */
	public void validate_and_sort() {
		PrintWriter error = null;
		try {
			error = new PrintWriter(new FileOutputStream("semantic_error_file.txt"));
		}
		catch(IOException e) {
			System.out.println("Error writing to file");
		}
		for (int i = 0;i<books.length;i++) {
			try {
				if(!isDouble(books[i][3]))
					throw new BadPriceException();
				else if(Double.parseDouble(books[i][3])<0||books[i][3].substring(books[i][3].indexOf(".")+1).length()>2)
					throw new BadPriceException();
				
				if (!isLong(books[i][6]))
					throw new BadYearException();
				else if(Integer.parseInt(books[i][6].trim())<1995||Integer.parseInt(books[i][6].trim())>2010)
					throw new BadYearException();
				if (books[i][4].length()==10) {
					if (!isLong(books[i][4])) 
						throw new BadIsbn10Exception();
					else if(!validateISBN(books[i][4]))
						throw new BadIsbn10Exception();
				}
				if (books[i][4].length()==13) {
					if (!isLong(books[i][4])) 
						throw new BadIsbn13Exception();
					else if(!validateISBN(books[i][4]))
						throw new BadIsbn13Exception();
					
				}
				
			}
			catch(BadIsbn10Exception e) {
				error.print("semantic error in file:"+books[i][0]+
						"\n====================\n"
						+ e.getMessage()
						+ "\nRecord:");
				for (int k = 1;books[i][k]!=null;k++) {
					error.print(books[i][k]);
					if (books[i][k+1]!=null) {
						error.print(",");
					}
				}
				error.println("\n");
				continue;
			}
			catch(BadIsbn13Exception e) {
				error.print("semantic error in file:"+books[i][0]+
						"\n====================\n"
						+ e.getMessage()
						+ "\nRecord:");
				for (int k = 1;books[i][k]!=null;k++) {
					error.print(books[i][k]);
					if (books[i][k+1]!=null) {
						error.print(",");
					}
				}
				error.println("\n");
				continue;
			}
			catch(BadPriceException e) {
				error.print("semantic error in file:"+books[i][0]+
						"\n====================\n"
						+ e.getMessage()
						+ "\nRecord:");
				for (int k = 1;books[i][k]!=null;k++) {
					error.print(books[i][k]);
					if (books[i][k+1]!=null) {
						error.print(",");
					}
				}
				error.println("\n");
				continue;
			}
			catch(BadYearException e) {
				error.print("semantic error in file:"+books[i][0]+
						"\n====================\n"
						+ e.getMessage()
						+ "\nRecord:");
				for (int k = 1;books[i][k]!=null;k++) {
					error.print(books[i][k]);
					if (books[i][k+1]!=null) {
						error.print(",");
					}
				}
				error.println("\n");
				continue;
			}
			book_objs = increase_array(book_objs);
			book_objs[book_objs.length-1] = new Book(books[i][1],books[i][2],Double.parseDouble(books[i][3]),books[i][4],books[i][5],Integer.parseInt(books[i][6]));
		}
	}
	/**
	 * The process_string method breaks down a line of book information and stores it in an array.
	 * @param str is the line of book information to be processed.
	 * @param file_name is the name of the file where the line was read.
	 * @return gives the array of processed information.
	 */
	public String[] process_string(String str,String file_name) {
		String[] temp = null;
		String[] book = null;
		if(str.indexOf("\"")!=-1) {
			temp = str.substring(str.indexOf("\"",1)+2).split(",");
			book = new String[temp.length+2];
			book[0] = file_name;
			book[1] = str.substring(0,str.indexOf("\"",1)+1);
			for (int i =0;i<temp.length;i++) {
				book[i+2]=temp[i];
			}
			return book;
		}
		else {
			temp = str.split(",");
			book = new String[temp.length+1];
			book[0] = file_name;
			for(int i = 0;i<temp.length;i++) {
				book[i+1]=temp[i];
			}
			return book;
		}
	}
	/**
	 * vaidateISBN verifies whether the isbn of a book object is valid.
	 * @param str contains the isbn of the book to be validated.
	 * @return gives a boolean which is the result of the verification.
	 */
	public boolean validateISBN(String str) {
		if (str.length()==10) {
			if(sumDigits(str)%11!=0) {
				return false;
			}
			return true;

		}
		else if (str.length()==13) {
			long isbn = Long.parseLong(str);
			if(sumDigits(isbn)%10!=0) {
				return false;
			}
			return true;
		}
		return false;
	}
	/**
	 * sumDigits gives the sum of the digits of a number.
	 * @param num is the number (string) whose sum of digits is to be calculated.
	 * @return is an integer which is the sum of the digits.
	 */
	public int sumDigits(String num) {
		int sum  = 0;
		for (int i = 0;i<num.length();i++) {
			sum+=Integer.parseInt(num.substring(i,i+1));
		}
		return sum;
	}
	/**
	 * sumDigits gives the sum of the digits of a number.
	 * @param num is the number (long) whose sum of digits is to be calculated.
	 * @return is an integer which is the sum of the digits.
	 */
	public long sumDigits(long num) {
		if (num/10<1)
			return num;
		return (sumDigits((long)(num/10))+num-(long)(num/10)*10);
	}
	/**
	 * The increase_array method increases the number of rows a 2d String array has.
	 * @param array contains the array that is to be increased.
	 * @return gives the array that has been increased in size.
	 */
 	public String[][] increase_array(String[][] array) {
		String[][] temp = new String[array.length+1][10];
		for(int i = 0;i<array.length;i++) {
			for (int j = 0;j<array[i].length;j++) {
				temp[i][j]=array[i][j];
			}
		}
		return temp;
		
	}
 	/**
	 * The increase_array method increases the size of a String array.
	 * @param array contains the array that is to be increased.
	 * @return gives the array that has been increased in size.
	 */
	public String[] increase_array(String[] array) {
		String[] temp = new String[array.length+1];
		for(int i = 0;i<array.length;i++) {
			temp[i]=array[i];
		}
		return temp;
		
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
	 * isLong method returns whether or not a String contains a Long value
	 * @param str is the string to be checked.
	 * @return gives a boolean which is the result of the verification.
	 */
	public boolean isLong(String str) {
		try {
			Long.parseLong(str);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	/**
	 * isDouble method returns whether or not a String contains a Double value
	 * @param str is the string to be checked.
	 * @return gives a boolean which is the result of the verification.
	 */
	public boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
