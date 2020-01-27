import java.io.File;
import java.io.FileNotFoundException;
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
			System.out.println("\n\nBeginning auto test");
			Scanner fileTest;
			try {
				fileTest = new Scanner(new File("C:/Users/Ismael Jones/Documents/CS305/ijones52-tictactoe/src/inputs.txt"));
				test.play_auto(fileTest);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
	
	}
}
