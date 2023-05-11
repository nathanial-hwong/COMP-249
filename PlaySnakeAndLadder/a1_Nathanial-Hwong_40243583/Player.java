/**
 * The Player class contains methods players will use to play the game
 * as well as information about each player that is needed to play the game.
 * @author Natha
 *
 */
public class Player {
	private int score;
	private String name;
	private int initRoll;
	
	/**
	 * The Player method is a default constructor which initializes the variables.
	 */
	public Player() {
		score = 0;
		name = "";
		initRoll = 0;
	}
	/**
	 * The Player(String, int) method is a parameterized default constructor which assigns values to variables.
	 * 
	 * @param name is a string which contains the name of the first player
	 * @param initRoll is a variable which contains the value of the initial roll that decides the order of play
	 */
	public Player(String name,int initRoll) {
		this.score = 0;
		this.name = name;
		this.initRoll = initRoll;
	}
	/**
	 * The changeinitRoll method rerolls the initRoll variable in order to break a possible tie.
	 * 
	 * @param roll is the new initRoll value which is given by flipDice()
	 */
	public void changeinitRoll(int roll) {
		initRoll = roll;
	}
	/**
	 * The giveinitRoll method returns the value of initRoll
	 * 
	 * @return gives the initRoll variable's value.
	 */
	public int giveinitRoll() {
		return initRoll;
	}
	/**
	 * The givescore method returns the value of score.
	 * 
	 * @return gives the score variable's value
	 */
	public int givescore() {
		return this.score;
	}
	/**
	 * The givename method returns the value of name.
	 * 
	 * @return gives the name variable's value
	 */
	public String givename() {
		return this.name;
	}
	/**
	 * The copy(player) method copies the values of a player object which is given.
	 * 
	 * @param player is the Player object that will be copied
	 */
	public void copy(Player player) {
		this.name = player.givename();
		this.initRoll = player.giveinitRoll();
	}
	/**
	 * The flipDive method generates a random number between 1 and 6.
	 * 
	 * @return gives the random number that is generated
	 */
	public static int flipDice(){
		int roll = (int)(Math.random()*6+1);
		return roll;
	}
	/**
	 * The knockDown method brings a players score back to 0.
	 */
	public void knockDown() {
		score = 0;
	}
	/**
	 * The turn method updates the player's score and checks if they have reached a snake or a ladder.
	 */
	public void turn() {
		int roll = flipDice();
		this.score+=roll;
		if (score>100)
			score=200-score;
		System.out.println(name +" has rolled a "+roll+" and is now on square "+score);
		int scoreBeforeCheck = this.score;
		switch(this.score) {
			case 1:
				this.score = 38;
				break;
			case 4: 
				this.score = 14;
				break;
			case 9:
				this.score = 31;
				break;
			case 16:
				this.score = 6;
				break;
			case 21:
				this.score = 42;
				break;
			case 28:
				this.score = 84;
				break;
			case 36:
				this.score = 44;
				break;
			case 48:
				this.score = 30;
				break;
			case 51:
				this.score = 67;
				break;
			case 64:
				this.score = 60;
				break;
			case 71:
				this.score = 91;
				break;
			case 79:
				this.score = 19;
				break;
			case 80:
				this.score = 100;
				break;
			case 93:
				this.score = 68;
				break;
			case 95:
				this.score = 24;
				break;
			case 97:
				this.score = 76;
				break;
			case 98:
				this.score = 78;
				break;
			

		}
		if (scoreBeforeCheck>this.score)
			System.out.println(name+" has reached a snake and dropped down to square "+this.score);
		if (scoreBeforeCheck<this.score)
			System.out.println(name+" has reached a ladder and rose to square "+this.score);
		
	}
}
