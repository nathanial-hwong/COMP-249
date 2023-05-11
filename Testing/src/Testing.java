import java.util.*;
import java.io.*;

public class Testing{
	public static void main(String[] args){
		System.out.println(whatAmI(4,3));
	}
	public static double whatAmI(double d, int n) {
		if(n == 0)
		return 1;
		return d * whatAmI(d, n - 1);
		}
}


	