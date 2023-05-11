// -----------------------------------------------------
// Assignment 1
// Written by: Nathanial Hwong 40243583
// -----------------------------------------------------
/*My program is a snakes and ladders game. It is comprised of a game board and dice. 
  The program ends when one of the players reach the 100th square. */
import java.util.Scanner;
import java.util.Arrays;
/**
 * The PlaySnakeAndLadder class implements methods and initializes key variables
 * to emulate a game of Snake and Ladders.
 */
public class PlaySnakeAndLadder {
	/**
	 * This is driver method "main".
	 * 
	 * @param args ?
	 */
	public static void main(String[] args){
		//Welcome message and determine number of players
		System.out.println("Welcome to Nathanial's Snakes and Ladders game!"
				+ "\nPlease enter the number of playes who will participate: ");
		Scanner obj = new Scanner(System.in);
		int nbplayers=0;
		try{
			nbplayers = Integer.parseInt(obj.next());
			}
		catch (Exception e) {
			System.out.println("Error: Cannot execute the game with less than 2 players! Will exit");
			System.exit(0);
		}
		
		if (nbplayers>2) {
			System.out.println("Initialization was attempted for "+nbplayers+"number of players; however, this is only expected for an extended version of the game. Value will be set to 2");
			nbplayers = 2;
		}
		if (nbplayers<2) {
			System.out.println("Error: Cannot execute the game with less than 2 players! Will exit");
			System.exit(0);
		}
		//initializes all the players
		Player[] players = new Player[nbplayers];
		for (int i = 0;i<players.length;i++) {
			players[i] = new Player("Player "+(i+1),Player.flipDice()); 
		}
		
		System.out.println("Now deciding which player will start playing");
		System.out.println(players[0].givename()+" got a dice value of "+players[0].giveinitRoll()+"\n"
				+players[1].givename()+" got a dice value of "+players[1].giveinitRoll());
		//Sorts players in array by play order
		int reattempt = 0;
		for (int i = 1;i<players.length;i++)
			for (int j = 0;j<players.length-1;j++) {
				while (players[j].giveinitRoll()==players[j+1].giveinitRoll()) {
					System.out.println("A tie was achieved between "+players[j].givename()+" and "+players[j+1].givename()+". Attempting to break the tie");
					int scorej = Player.flipDice();
					int scorej1 = Player.flipDice();
					players[j].changeinitRoll(scorej);
					players[j+1].changeinitRoll(scorej1);
					System.out.println(players[j].givename()+" got a dice value of "+scorej
							+players[j+1].givename()+" got a dice value of "+scorej1);
					reattempt+=1;
				}	
				if (players[j].giveinitRoll()<players[j+1].giveinitRoll()) {
					Player playertemp1 = new Player(); playertemp1.copy(players[j]);
					Player playertemp2 = new Player(); playertemp2.copy(players[j+1]);
					players[j+1] = playertemp1;
					players[j] = playertemp2;
				}
			}
		if (reattempt>0)
			System.out.println("Reached final decision on order of playing after "+reattempt+"attempts.");
		System.out.println(players[0].givename()+" will play then "+players[1].givename()+" will play.");
		//prompts user to begin the game
		System.out.println("Please press [ENTER] to begin the game...");
		String next = obj.nextLine();
		next = obj.nextLine();
		//initialize board values
		Integer[][] board = new Integer[10][10];
		for (int i=0;i<10;i++)
			for (int j = 0; j<10;j++) {
				if (i%2==1) {
					board[i][j]=(10-i-1)*10+j+1;
				}
				else if (i%2==0) {
					board[i][j]=(10-i)*10-j;
				}
			}	
		//begin game
		play(players,board);
			
			
			
		
		//exit message
		System.out.println("Thanks for playing, now exiting the program.");
	}
	/**
	 * The play method begins the game.
	 * 
	 * @param players is an array that contains all Player objects
	 * @param board is an integer array that contains the data needed to display the game board
	 */
	public static void play(Player[] players,Integer[][] board) {
		
		Scanner obj =  new Scanner(System.in);
		String next = "";	
		boolean end = false;
		while (end ==false) {
			//First player plays
			players[0].turn();
			if (players[0].givescore()==players[1].givescore()) {
				players[1].knockDown();
				System.out.println(players[1].givename()+" has been knocked back down to square 0");
			}
			//second player plays
			players[1].turn();
			if (players[0].givescore()==players[1].givescore()) {
				players[0].knockDown();
				System.out.println(players[0].givename()+" has been knocked back down to square 0");
			}
			System.out.println();
			//display new state of board
			for (int i=0;i<10;i++) {
				for (int j = 0; j<10;j++) {
					if (board[i][j]==players[0].givescore())
						System.out.print("|P1| ");
					else if(board[i][j]==players[1].givescore())
						System.out.print("|P2| ");
					else {	
						System.out.print(board[i][j]);
						for (int k = 0; k<5-(board[i][j].toString().length());k++)
							System.out.print(" ");
						}
				}
				System.out.println();
			}
				//check if the game ended
				if (players[0].givescore()==100) {
					System.out.println(players[0].givename()+" has won the game!");
					end = true;
				}
				else if (players[1].givescore()==100) {
					System.out.println(players[1].givename()+" has won the game!");
					end = true;
				}
				else{
					System.out.println("Game not over; "
							+ "Please press [ENTER] to roll the dice...");
					next = obj.nextLine();
					
				}
				
				
			}
	}

}
