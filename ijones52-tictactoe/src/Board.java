/** 
 * This class is the basis of the game. Handles all of the base things to run the game. Posistions, printing the 
 * board, win conditions, and draw conditions
 * 
 * @author Ismael Jones
 * @version 1/22/20
 * */
public class Board {
	/**
	 * Fields to handle the rows of the board as well as the "X" or "O" Values and full and tie values;
	 * */
	private String[][] board;
	private String row1;
	private String betweenRow1 = "---|---|---";
	private String row2;
	private String betweenRow2 = "---|---|---";
	private String row3;
	private boolean isFull = false;
	private boolean isTie = false;
	
	public Board() {
		board = new String[3][3];
		for(int i = 0; i < board.length; i ++) {
			for(int j =0; j < board[i].length; j++) {
				board[i][j]=" ";
			}
		}
		row1 = " "+ board[0][0] +" | " + board[0][1] +" | " + board[0][2] + " ";
		row2 = " "+ board[1][0] +" | " + board[1][1] +" | " + board[1][2] + " ";
		row3 = " "+ board[2][0] +" | " + board[2][1] +" | " + board[2][2] + " ";
				
	}
	/**
	 * Checks to see if all the values of the board are not empty
	 * 
	 * @return true if full, false if not;
	 * */
	public boolean isFull() {
		int count =0;
		for(int i = 0; i < board.length; i ++) {
			for(int j =0; j < board.length; j++) {
				if(!board[i][j].equals(" ")) {
					count ++;
				}
			}
		}
		if(count == 9) {
			isFull =true;
		}
		return isFull;
	}
	/**
	 * Check the board is full and checkWinner(X) and checkWinner(O) both return false. If conditions are met this is 
	 * a draw, if not this is not a draw;
	 * 
	 * @return true if a tie is detected and false if not
	 * 
	 * */
	public boolean isTie() {
		if(isFull() && !checkWinner("X") && !checkWinner("O")) {
			isTie = true;
		}
		
		return isTie;
	}
	/**
	 * Traverses the array to check if there is a winner of a specific character across verticals, horizontals,
	 * and both the diagonals. 
	 * 
	 * @param the player "X" or "O" to check
	 * @return true if the player has won, false if not
	 * */
	public boolean checkWinner(String player) {
		//traverse all the rows with nested loop
		for(int i = 0; i < board.length; i ++) {
			for(int j=0; j< board[i].length; j++) {
				if(board[i][j].equals(player)&& board[i][j+1].equals(player) && board[i][j].equals(player)) {
					return true;
				}
				else {
					break;
				}
			}
		}
		
		//traverse all the columns with nested loop
		for(int i = 0; i < board.length; i ++) {
			for(int j=0; j< board[i].length; j++) {
				if(board[i][j].equals(player) && board[i+1][j].equals(player) && board[i+2][j].equals(player)) {
					return true;
				}
			}
			break;
		}
		//traverse both the diagonals with nested loop
		if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)){
			return true;
		}
		else if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
			return true;
		}
		else {
		return false;
		}
	}
	/**
	 * A method that updates the array of characters updataing the board
	 * 
	 * @param the x value of the position
	 * @param the y value of the position
	 * @param the player that placing the piece
	 * */
	public void updateBoard(int x, int y, String player) {
		if(isValidMove(x,y)) {
			board[x][y] = player;
		}
		else {
			System.out.println("Invalid move, please make another move");
		}
	}
	/**
	 * A method that checks if a move can be done seeing is there is already a piece on that place
	 * 
	 * @param the x value of the position
	 * @param the y value of the position
	 * */
	public boolean isValidMove(int x, int y) {
		if(!board[x][y].equals(" ")) {
			return false;
		}
		else {
			return true;
		}
	}
	public String toString(){
		return row1 + "\n" + betweenRow1 + "\n" + row2 + "\n" + betweenRow2 + "\n" + row3;
	}
}
