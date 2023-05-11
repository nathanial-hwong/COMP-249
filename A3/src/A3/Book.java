// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 3
// Due Wednesday March 29th 2023
// -----------------------------------------------------
package A3;
import java.io.Serializable;
/**
 * Book class defines a new Book type object that holds all information for a book entry.
 * @author Natha
 *
 */
public class Book implements Serializable{
	private String title;
	private String author;
	private double price;
	private String isbn;
	private String genre;
	private int year;
	/**
	 * Default constructor for class Book.
	 */
	public Book() {
		title="";
		author="";
		price=0;
		isbn="";
		genre="";
		year=0;
	}
	/**
	 * Parameterized constructor for class Book that takes information for each attribute.
	 * @param title is a string which represents title of the book.
	 * @param author is a string which represents author of the book.
	 * @param price is the price of the book.
	 * @param isbn is a string which represents isbn of the book.
	 * @param genre is a string which represents genre of the book.
	 * @param year is the year the book was published
	 */
	public Book(String title,String author, double price, String isbn, String genre, int year) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.genre = genre;
		this.year = year;
	}
	/**
	 * Copy constructor which takes a book object and returns a copy of the object.
	 * @param book contains the book object to be copied.
	 */
	public Book(Book book) {
		this.title = book.getTitle();
		this.author = book.getAuthor();
		this.price = book.getPrice();
		this.isbn = book.getIsbn();
		this.genre = book.getGenre();
		this.year = book.getYear();
	}
	/**
	 * getTitle returns the title of a book object.
	 * @return gives the value of variable title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * getAuthor returns the author of a book object.
	 * @return gives the value of variable author.
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * getPrice returns the price of a book object.
	 * @return gives the value of variable price.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * getIsbn returns the ISBN of a book object.
	 * @return gives the value of variable isbn.
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * getGenre returns the genre of a book object.
	 * @return gives the value of variable genre.
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * getYear returns the publishing year of a book object.
	 * @return gives the value of variable year.
	 */
	public int getYear() {
		return year;
	}
	
}
