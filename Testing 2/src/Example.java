import java.util.Arrays;
import java.util.Scanner;
	public class Example{
		public static void main(String[] args){
			Airplane[] planes = new Airplane[5];
			for (int i = 0;i<5;i++) {
				planes[i]=new Airplane();
			}
			Scanner obj =  new Scanner(System.in);
			System.out.println("Give values for plane 1: ");
			planes[0].setAll(obj.nextInt(),obj.nextDouble(),obj.nextInt());
			System.out.println("Give values for plane 2: ");
			planes[1].setAll(obj.nextInt(),obj.nextDouble(),obj.nextInt());
			System.out.println("Give values for plane 3: ");
			planes[2].setAll(obj.nextInt(),obj.nextDouble(),obj.nextInt());
			System.out.println("Give weight and speed for plane 4: ");
			planes[2].setWS(obj.nextDouble(),obj.nextInt());
			planes[2].setAll(planes[0].givePasseng(), planes[1].giveW(), planes[2].giveSpe());
			for (int i =0;i<5;i++) {
				System.out.println(planes[i]);
			
			}
			System.out.println("The fastest plane is "+planes[findFasterAirplane(planes)]);
			System.out.println("The average weight is "+getAverageWeight(planes));
			System.out.println(Airplane.equals(planes[1],planes[0]));
			
		}
		public static double getAverageWeight(Airplane[] planes) {
			int num = 0;
			double sum = 0;
			for (int i =0;i<5;i++) {
				sum += planes[i].giveW();
				num = i+1;
			}
			return sum/num;
		}
		public static int findFasterAirplane(Airplane[] planes) {
			int max = 0;
			int imax = 0;
			for (int i =0;i<5;i++) {
				if (planes[i].giveSpe()>max)
				{max = planes[i].giveSpe();
				imax = i;}
			}
			return imax+1;
		}
		
		
		
		
	}

