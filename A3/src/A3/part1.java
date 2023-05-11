// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// Question: Part 1 of 3
// -----------------------------------------------------
package A3;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import SynxtaxErrors.*;
/**
 * part1 class defines methods necessary to read files containing book information and processing the information.
 * This class removes books objects with Missing fields, with the wrong amount of fields, and with unknown genres.
 * @author Natha
 *
 */
public class part1 {
	
	protected String[] file_genres = {"CCB","HCB","MTV","MRB","NEB","OTR","SSM","TPA"};
	protected int[] books_per_genre = new int[file_genres.length];
	protected String[][] books = new String[0][10];
	/**
	 * The do_part1 method implements other methods in the class to create the proper output files.
	 */
	public void do_part1() {
		String[] files = getFiles("part1_input_file_names.txt");
		for(int i = 0;i<files.length;i++) {
			readBooksFile(files[i]);
		}
		validate_and_sort();
		created_files("part2_input_file_names.txt");
	}
	/**
	 * The method created_files outputs a file containing the output files that will be used read from in the part2 class.
	 * @param list contains the file name for the file that will be created.
	 */
	public void created_files(String list) {
		PrintWriter p = null;
		try {
			p = new PrintWriter(new FileOutputStream(list));
		}
		catch(IOException e) {
			System.out.println("Error writing to file");
		}
		p.println("8"
				+ "\nCartoons_Comics_Books.csv.txt"
				+ "\nHobbies_Collectibles_Books.csv.txt"
				+ "\nMovies_TV.csv.txt"
				+ "\nMusic_Radio_Books.csv.txt"
				+ "\nNostalgia_Eclectic_Books.csv.txt"
				+ "\nOld_Time_Radio.csv.txt"
				+ "\nSports_Sports_Memorabilia.csv.txt"
				+ "\nTrains_Planes_Automobiles.csv.txt");
		p.close();
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
			book[0]=file_name;
			book[1] = str.substring(0,str.indexOf("\"",1)+1);
			for (int i =0;i<temp.length;i++) {
				book[i+2]=temp[i];
			}
			return book;
		}
		else {
			temp = str.split(",");
			book = new String[temp.length+1];
			book[0]=file_name;
			for(int i = 0;i<temp.length;i++) {
				book[i+1]=temp[i];
			}
			return book;
			}

	}
	/**
	 * The validate and sort method goes through the books array and sorts the books found in it.
	 * It then sorts and writes valid books into their files by genre and writes invalid books to the error file.
	 */
	public void validate_and_sort(){
		PrintWriter error = null;
		PrintWriter ccb = null;
		PrintWriter hcb = null; 
		PrintWriter mtv = null; 
		PrintWriter mrb = null; 
		PrintWriter neb = null; 
		PrintWriter otr = null; 
		PrintWriter ssm = null; 
		PrintWriter tpa = null;
		try {
			error = new PrintWriter(new FileOutputStream("syntax_error_file.txt")); 
			ccb = new PrintWriter(new FileOutputStream("Cartoons_Comics_Books.csv.txt"));
			hcb = new PrintWriter(new FileOutputStream("Hobbies_Collectibles_Books.csv.txt"));
			mtv = new PrintWriter(new FileOutputStream("Movies_TV.csv.txt"));
			mrb = new PrintWriter(new FileOutputStream("Music_Radio_Books.csv.txt"));
			neb = new PrintWriter(new FileOutputStream("Nostalgia_Eclectic_Books.csv.txt"));
			otr = new PrintWriter(new FileOutputStream("Old_Time_Radio.csv.txt"));
			ssm = new PrintWriter(new FileOutputStream("Sports_Sports_Memorabilia.csv.txt"));
			tpa = new PrintWriter(new FileOutputStream("Trains_Planes_Automobiles.csv.txt"));
		}
		catch(IOException e) {
			System.out.println("Error writing to file");
		}
		for (int i = 0; i<books.length;i++) {
			int j = 0;
			try {
				
				if(books[i][7]!=null)
					throw new TooManyFieldsException();

				if(books[i][6]==null)
					throw new TooFewFieldsException();
				
				while(j<6) {
					if(books[i][j].trim()=="")
						throw new MissingFieldException(j);
					j++;
				}
				while(j<file_genres.length) {
					if(books[i][5].trim().equals(file_genres[j]))
						throw new UnknownGenreException();
					j++;
				}
			}
			catch(TooManyFieldsException e){
				
				error.print("syntax error in file:"+books[i][0]+
							"\n===================="
							+ "\nError: "+e.getMessage()+"\nRecord:");
				for (int k = 1;books[i][k]!=null;k++) {
					error.print(books[i][k]);
					if (books[i][k+1]!=null) {
						error.print(",");
					}
				}
				error.println("\n");
				continue;
			}
			catch(TooFewFieldsException e){
				
				error.print("syntax error in file:"+books[i][0]+
						"\n===================="
						+ "\nError: "+e.getMessage()+"\nRecord:");
				for (int k = 1;books[i][k]!=null;k++) {
					error.print(books[i][k]);
					if (books[i][k+1]!=null) {
						error.print(",");
					}
				}
				error.println("\n");
				continue;
			}
			catch(MissingFieldException e){
				error.print("syntax error in file:"+books[i][0]+
						"\n===================="
						+ "\nError: "+e.getMessage()
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
			catch(UnknownGenreException e) {
				error.print("syntax error in file:"+books[i][0]+
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
			PrintWriter[] output_files = {ccb,hcb,mtv,mrb,neb,otr,ssm,tpa};
			for (int k = 0;k<file_genres.length;k++) {
				if((books[i][5].trim()).equals(file_genres[k])) {
					books_per_genre[k]++;
					for (int l = 1;books[i][l]!=null;l++) {
						output_files[k].print(books[i][l]);
						if (books[i][l+1]!=null) {
							output_files[k].print(",");
						}
					}
					output_files[k].println();
					break;
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
	/**
	 * The increase_array method increases the number of rows a 2d String array has.
	 * @param array contains the array that is to be increased.
	 * @return gives the array that has been increased in size.
	 */
	public String[][] increase_array(String[][] array) {
		String[][] temp = new String[array.length+1][10];
		for(int i = 0;i<array.length;i++) {
			for (int j = 0;array[i][j]!=null;j++) {
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
}

