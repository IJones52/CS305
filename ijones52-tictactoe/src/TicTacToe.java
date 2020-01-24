import java.util.Scanner;

/**
	 * Here we can start the game,
	 * set the gamemode to auto or normal, and handle quitting.
	 * 
	 * @author Ismael Jones
	 * @version 1/22/20
	 * */
public class TicTacToe {
	

	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			TicTacToeTester test = new TicTacToeTester();
			System.out.println("Process finished with exit code " + test.play(in));
	
	}
}
