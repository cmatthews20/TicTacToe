/**
 * Represents a move (by the player or the AI) to a particular cell.
 */

public class Move {
	private int i;
	private int j;
	private char piece;

	public Move(int i, int j, char piece) {
		this.i = i;
		this.j = j;
		this.piece = piece;
	}
	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}
	
	public char getPiece() {
		return piece;
	}
}
