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
	
	public TicTacToeTester() {}
	
	public int play(Scanner in) {
		Board b = new Board();
		System.out.println("Welcome to Tic Tac Toe!");
		while(!b.checkWinner(player1) && !b.checkWinner(player2)) {
			while(true) {
				System.out.println(player1 + "'s turn!");
				System.out.println("Enter the x and the y coordinates of your next move, e.g. 0 0 or 1 2, or enter 'quit to exit");
				int xCoord = in.nextInt();
				int yCoord = in.nextInt();
				b.updateBoard(xCoord,yCoord,player1);
				if(b.isValidMove(xCoord, yCoord)) {
					continue;
				}
				else {
					System.out.println(b.toString());
					b.checkWinner(player1);
				}
				break;
			}
			if(b.checkWinner(player1)) {break;}
			while(true) {
				System.out.println(player2 + "'s turn!");
				System.out.println("Enter the x and the y coordinates of your next move, e.g. 0 0 or 1 2, or enter 'quit to exit");
				int xCoord = in.nextInt();
				int yCoord = in.nextInt();
				b.updateBoard(xCoord,yCoord,player2);
				if(b.isValidMove(xCoord, yCoord)) {
					continue;
				}
				else {
					System.out.println(b.toString());
					b.checkWinner(player2);
					break;
				}
			}
		}
		
		
		
		
		
		
		
		
		return 0;
		
	}
	public void play_auto(Scanner in) {
		
	}
}
