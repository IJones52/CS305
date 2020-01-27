import java.util.Scanner;
/**
 *  The main gameplay loop is ran through here. This class has all of the methods that make up handling
 *  turns and players inputs. Calling all of the methods to update the board as necessary.
 *  
 *  @author Ismael Jones
 *  @version1/22/20
 * */
public class TicTacToeTester {
	private String player1 = "X";
	private String player2 = "O";
	
	/**
	 * 
	 * A blank constructor because nothing needs to be initialized, but I need to construct a Tester object
	 * */
	public TicTacToeTester() {}
	/**
	 * This method that runs the two player game. A loop that checks if either player has won, within that a loop
	 * that runs through a turn for both X and O. Within it checks for move validity, updates the board and checks for
	 * winners. In addition it handles the case of a tie
	 * 
	 * 
	 * @param A scanner to read in player input from the console
	 * 
	 * */
	public int play(Scanner in) {
		Board b = new Board();
		System.out.println("Welcome to Tic Tac Toe!");
		while(!b.checkWinner(player1) && !b.checkWinner(player2) && !b.isTie()) {
			while(true) {
				System.out.println(player1 + "'s turn!");
				System.out.println("Enter the x and the y coordinates of your next move, e.g. 0 0 or 1 2, or enter 'quit to exit");
				int xCoord = 0;
				int yCoord = 0;
				if(in.hasNextInt()) {
					xCoord = in.nextInt();
					yCoord = in.nextInt();
				}
				else if(in.hasNext()) {
					if(in.next().equals("quit")) {
						return 1;
					}
					else {
						System.out.println("Invalid input, please try again");
						continue;
					}
				}

				if(!b.isValidInput(xCoord, yCoord)) {
					System.out.println("Invalid input, please try again");
					continue;
					
				}
				else if(!b.isValidMove(xCoord, yCoord)) {
					System.out.println("Invalid move, please try again");
					continue;
				}
				else {
					b.updateBoard(xCoord,yCoord,player1);
					System.out.println(b.toString());
					b.checkWinner(player1);

				}
				break;
			}
			if(b.checkWinner(player1) || b.isTie()) {break;}
			while(true) {
				System.out.println(player2 + "'s turn!");
				System.out.println("Enter the x and the y coordinates of your next move, e.g. 0 0 or 1 2, or enter 'quit to exit");
				int xCoord = 0;
				int yCoord = 0;
				if(in.hasNextInt()) {
					xCoord = in.nextInt();
					yCoord = in.nextInt();
				}
				else if(in.hasNext()) {
					if(in.next().equals("quit")) {
						return 1;
					}
					else {
						System.out.println("Invalid input, please try again");
						continue;
					}
				}
				if(!b.isValidInput(xCoord, yCoord)) {
					System.out.println("Invalid input, please try again");
					continue;
				}
				else if(!b.isValidMove(xCoord, yCoord)) {
					System.out.println("Invalid move, please try again");
					continue;
				}
				else {
					b.updateBoard(xCoord,yCoord,player2);
					System.out.println(b.toString());
					b.checkWinner(player2);
					break;
				}
			}
		}
		if(b.checkWinner(player1)) {
			System.out.println("I declare the winner by outright triumph... Player 1! \nCongratulations, Player 1!");
		}
		else if(b.checkWinner(player2)) {
			System.out.println("I declare the winner by outright triumph... Player 2! \nCongratulations, Player 2!");
		}
		else if(b.isTie()) {
			System.out.println("I declare this match a draw! \nWell played, Player 1 and Player 2!");
		}
		return 0;
		
	}
	
	
	/**
	 * A method that reads the input of a file for the players moves instead of taking player input.
	 * The code for gameplay should be entirely the same, just no return value
	 * 
	 * @param a scanner that is reading a file
	 * */
	public void play_auto(Scanner in) {
		Board b = new Board();
		System.out.println("Welcome to Tic Tac Toe!");
		while(!b.checkWinner(player1) && !b.checkWinner(player2) && !b.isTie()) {
			while(true) {
				System.out.println(player1 + "'s turn!");
				System.out.println("Enter the x and the y coordinates of your next move, e.g. 0 0 or 1 2, or enter 'quit to exit");
				int xCoord = 0;
				int yCoord = 0;
				if(in.hasNextInt()) {
					xCoord = in.nextInt();
					yCoord = in.nextInt();
				}
				else if(in.hasNext()) {
					if(in.next().equals("quit")) {
						return;
					}
					else {
						System.out.println("Invalid input, please try again");
						continue;
					}
				}

				if(!b.isValidInput(xCoord, yCoord)) {
					System.out.println("Invalid input, please try again");
					continue;
					
				}
				else if(!b.isValidMove(xCoord, yCoord)) {
					System.out.println("Invalid move, please try again");
					continue;
				}
				else {
					b.updateBoard(xCoord,yCoord,player1);
					System.out.println(b.toString());
					b.checkWinner(player1);

				}
				break;
			}
			if(b.checkWinner(player1) || b.isTie()) {break;}
			while(true) {
				System.out.println(player2 + "'s turn!");
				System.out.println("Enter the x and the y coordinates of your next move, e.g. 0 0 or 1 2, or enter 'quit to exit");
				int xCoord = 0;
				int yCoord = 0;
				if(in.hasNextInt()) {
					xCoord = in.nextInt();
					yCoord = in.nextInt();
				}
				else if(in.hasNext()) {
					if(in.next().equals("quit")) {
						return;
					}
					else {
						System.out.println("Invalid input, please try again");
						continue;
					}
				}
				if(!b.isValidInput(xCoord, yCoord)) {
					System.out.println("Invalid input, please try again");
					continue;
				}
				else if(!b.isValidMove(xCoord, yCoord)) {
					System.out.println("Invalid move, please try again");
					continue;
				}
				else {
					b.updateBoard(xCoord,yCoord,player2);
					System.out.println(b.toString());
					b.checkWinner(player2);
					break;
				}
			}
		}
		if(b.checkWinner(player1)) {
			System.out.println("I declare the winner by outright triumph... Player 1! \nCongratulations, Player 1!");
		}
		else if(b.checkWinner(player2)) {
			System.out.println("I declare the winner by outright triumph... Player 2! \nCongratulations, Player 2!");
		}
		else if(b.isTie()) {
			System.out.println("I declare this match a draw! \nWell played, Player 1 and Player 2!");
		}
	}
}
