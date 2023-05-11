package InputVer;
import java.util.Scanner;

public class InputVer {
	public void nextInt() {
		boolean read = false;
		Scanner obj = new Scanner(System.in);
		int get=0;
		boolean ok = true;
		do {
			try {
				ok = true;
				System.out.println("Input an int: ");
				get = obj.nextInt();
			}
			catch(Exception e){
				String bad = obj.next();
				System.out.println("Not an int, try again.");
				ok = false;
			}
		}
		while (ok==false);
	}
	
}
