
public class Airplane {
	private int nbOfPassengers;
	private double weight;
	private int maxSpeed;
	public Airplane(){
		nbOfPassengers = 0;	
		weight = 0;
		maxSpeed = 0;
	}
	public int givePasseng() {
		return nbOfPassengers;
	}
	public double giveW() {
		return weight;
	}
	public int giveSpe() {
		return maxSpeed;
	}
	public void changeP(int p) {
		nbOfPassengers = p;
	}
	public void changeW(double w) {
		weight = w;
	}
	public void changeS(int s) {
		maxSpeed=s;
	}
	public void setWS(double w, int s) {
		changeW(w);
		changeS(s);
	}
	public void setAll(int p, double w, int s) {
		changeP(p);
		weight = w;
		changeW(w);
		changeS(s);
	}
	public static boolean equals(Airplane o1, Airplane o2) {
		if(o1.givePasseng()==o2.givePasseng()
				&& o1.giveW()==o2.giveW()
				&& o1.giveSpe()==o2.giveSpe()) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		String str="Plane with capacity of "+nbOfPassengers+", weighing "+weight+"kg can travel at a maximum speed of "+maxSpeed+"km/hr";
		
		return str;
	}
	
}
