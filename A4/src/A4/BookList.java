// -----------------------------------------------------
// Name and ID Nathanial Hwong 40243583
// COMP249
// Assignment 4
// Due Monday April 17 2023
// -----------------------------------------------------
package A4;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * The BookList class defines the BookList method which holds Book objects in a linked circular list.
 * It also defines methods used to change the list and add books.
 * @author Natha
 *
 */
public class BookList {
	Node head;
	/**
	 * A Node class object holds a book object and the address of the next Node in a linked list.
	 * @author Natha
	 *
	 */
	private class Node {
		private Book b;
		private Node next;
		/**
		 * The Node default constructor initializes the b and next variables.
		 */
		private Node() {
			b = null;
			next = null;
		}
		/**
		 * The Node parameterized constructor takes a book object and node object and assigns those values to a Node object
		 * @param b is the book object the Node will hold.
		 * @param next is the next Node in the linked list.
		 */
		private Node(Book b, Node next) {
			this.b = b;
			this.next = next;
		}
	}
	/**
	 * The BookList default constructor initializes the head variable of a BookList object
	 */
	public BookList() {
		head = null;
	}
	/**
	 * The addToStart method adds a new Node at the front of a linked list which holds the book object passed in the method.
	 * @param b is the book object to be added to the front of the list.
	 */
	public void addToStart(Book b) {
		Node temp = new Node(b,head);
		Node tail = getTail();
		if (head==null) {
			head = temp;
		}
		else {
			head = temp;
			tail.next = temp;
		}
	}
	/**
	 * the getTail method returns the Node at the end of a linked list.
	 * @return gives the Node at the end of the list.
	 */
	public Node getTail() {
		Node temp = head;
		while (temp!=null&&temp.next!=null&&temp.next!=head) {
			temp = temp.next;
		}
		return temp;
	}
	/**
	 * The storeRecordByYear method takes a year and writes all book entries with the same year in a new file.
	 * @param yr is the publishing year of books to be stored.
	 */
	public void storeRecordByYear(int yr) {
		String output = yr+".txt";
		BookList l = new BookList();
		Node temp=head;
		if (head!=null) {
			for(int i = 0;i<size();i++) {
				if (temp.b.getYear()==yr)
					l.addToStart(temp.b);
				temp = temp.next;
			}
			if (l.head==null)
				System.out.println("No books of this year.");
			else {
				PrintWriter p = null;
				try {
					p = new PrintWriter(new FileOutputStream(output));
					Node temp2 = l.head;
					Book b;
					for(int i = 0;i<l.size();i++) {
						b = temp2.b;
						p.println(b.getTitle()+","+b.getAuthor()+","+b.getPrice()+","+b.getIsbn()+","+b.getGenre()+","+b.getYear());
						temp2 = temp2.next;
					}
				}
				catch(IOException e) {
					System.out.println("Error writing file.");
				}
				catch(Exception e) {
					System.out.println("Error writing file.");
				}
				p.close();
			}
		}
	}
	/**
	 * the insertBefore method takes an ISBN value and inserts a Book object before the book which matches the ISBN value.
	 * @param isbn is a Long value which represents the ISBN of a book entry to find.
	 * @param b is the Book object to be added.
	 * @return confirms whether or not the insert was successful.
	 */
	public boolean insertBefore(long isbn, Book b) {
		Node temp = head;
		if (temp==null)
			return false;
		for(int i = 0;i<size();i++) {
			if (temp.next.b.getIsbn()==isbn||head.b.getIsbn()==isbn) 
				break;
		temp = temp.next;
		}
		if(temp.next.b.getIsbn()!=isbn)
			return false;
		Node insert = new Node(b,temp.next);
		temp.next = insert;
		return true;
	}
	/**
	 * The insertBetween takes 2 ISBN values and inserts a Book object between 2 books that match the ISBN values.
	 * @param isbn1 is the first ISBN value.
	 * @param isbn2 is the second ISBN value.
	 * @param b is the Book object to insert.
	 * @return confirms whether or not the insert was successful.
	 */
	public boolean insertBetween(long isbn1,long isbn2,Book b) {
		Node tempBefore = head;
		Node tempAfter = head;
		int count1 = 0;
		int count2 = 0;
		Node insert;
		if (head==null)
			return false;
		for(int i = 0;i<=size();i++) {
			if (tempBefore.b.getIsbn()==isbn1) {
				count1 = i;
				break;
			}
		tempBefore = tempBefore.next;
		}
		for(int i = 0;i<=size();i++) {
			if (tempAfter.b.getIsbn()==isbn2) {
				count2 = i;
				break;
			}
		tempAfter = tempAfter.next;
		}
		if(count1==size()-1&&count2==0) {
			insert = new Node(b,head);
			tempBefore.next = insert;
			return true;
		}
		if(count1-count2!=1&&count2-count1!=1)
			return false;
		if (tempBefore.b.getIsbn()!=isbn1||tempAfter.b.getIsbn()!=isbn2)
			return false;
		insert = new Node(b,tempAfter);
		tempBefore.next = insert;
		return true;
	}
	/**
	 * The displayContent method prints the Book entries in the list on the console.
	 */
	public void displayContent() {
		Node temp = head;
		if (head!=null) {
			for (int i = 0; i<size();i++) {
				System.out.println(temp.b+"==>");
				temp = temp.next;
			}
			System.out.println("==>head");
		}
	}
	/**
	 * The delConsecutiveRepeatedRecords method deletes duplicate consecutive Book objects in the list.
	 * @return confirms whether or not the method was successful.
	 */
	public boolean delConsecutiveRepeatedRecords() {
		Node temp = head;
		boolean removed = false;
		if (head==null)
			return false;
		for (int i = 0;i<size()-1;i++) {
			if (temp.b.equals(temp.next.b)) {
				temp.next=temp.next.next;
				i--;
				removed = true;
				continue;
			}
			temp = temp.next;
		}
		return removed;
	}
	/**
	 * The size method gives the length of the BookList.
	 * @return gives an integer length of the list.
	 */
	public int size() {
		int size = 1;
		Node temp = head;
		if (head==null)
			return 0;
		while (temp.next!=head&&temp.next!=null) {
			size++;
			
			temp = temp.next;
		}
		return size;
	}
	/**
	 * The extractAuthList method takes an author string, finds all Book entries with the same author, and gives a list of the authors
	 * @param aut is the author string.
	 * @return gives the list of authors.
	 */
	public BookList extractAuthList(String aut) {
		BookList specAuthor = new BookList();
		Node temp = head;
		if (head==null) {
			return specAuthor;
		}
		for (int i = 0; i<size(); i++) {
			if (temp.b.getAuthor().equals(aut))
				specAuthor.addToStart(temp.b);
			temp = temp.next;
		}
		return specAuthor;
	}
	/**
	 * The swap method takes 2 ISBN values and swaps the books in the list which correspond to the ISBNs given.
	 * @param isbn1 is the first ISBN value.
	 * @param isbn2 is the second ISBN value.
	 * @return confirms whether or not the method was successful.
	 */
	public boolean swap(long isbn1,long isbn2) {
		if (head==null)
			return false;
		Node node1 = head;
		Node node2 = head;
		Node tempSwap1;
		Node tempSwap2;
		Node tempNext1;
		Node tempNext2;
		int count1 = 0;
		int count2 = 0;
		boolean foundNode1 = false;
		boolean foundNode2 = false;
		for (int i = 0; i<size();i++) {
			if (node1.next.b.getIsbn()==isbn1) {
				foundNode1 = true;
				count1 = i;
				break;
			}
			node1 = node1.next;
		}
		if (!foundNode1)
			return false;
		for (int i = 0; i<size();i++) {
			if (node2.next.b.getIsbn()==isbn2){
				foundNode2 = true;
				count2 = i;
				break;
			}
			node2 = node2.next;
		}
		if (!foundNode2)
			return false;
		tempSwap1 = node1.next;
		tempSwap2 = node2.next;
		tempNext1 = node1.next.next;
		tempNext2 = node2.next.next;
		if (tempSwap1==tempNext2||tempSwap2==tempNext1) {
			node2.next.next=tempSwap1;
			node1.next.next=tempNext2;
			node1.next=tempSwap2;
			node2.next=tempNext2;
			return true;
		}
		node2.next.next = tempNext1;
		node1.next.next = tempNext2;
		node2.next=tempSwap1;
		node1.next=tempSwap2;
		
		return true;
	}
	/**
	 * The commit method outputs all books in the BookList into the "Update_Books.txt" file.
	 */
	public void commit() {
		Node temp = head;
		PrintWriter p = null;
		try {
			p = new PrintWriter(new FileOutputStream("Update_Books.txt"));
			for(int i = 0; i<size();i++) {
				Book b = temp.b;
				p.println(b.getTitle()+","+b.getAuthor()+","+b.getPrice()+","+b.getIsbn()+","+b.getGenre()+","+b.getYear());
				temp = temp.next;
			}
		}
		catch(IOException e) {
			System.out.println("Error writing file.");
		}
		
		p.close();
	}
	/**
	 * The reverseList method reverses the book list.
	 * @return gives the reversed list.
	 */
	public BookList reverseList() {
		BookList tempB = new BookList();
		Node tempN = head;
		for (int i = 0; i<size();i++) {
			tempB.addToStart(tempN.b);
			tempN=tempN.next;
		}
		return tempB;
	}
}
