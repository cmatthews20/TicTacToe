/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 */

public class Board {

    private char[][] board = new char[3][3];
    public char empty = ' ';

    /*
     * TBD: Additional private members?
     */

    /**
     * Construct an empty board (all space chars).
     */
    public Board() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = empty;
            }
        }
    }

    /**
     * Given the 'other' board as a starting condition, apply the given
     * 'move' to generate this board's state.
     */
    public Board(Board other, Move move) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = other.get(i,j);
            }
        }
        board[move.getI()][move.getJ()] = move.getPiece();
    }

    /**
     * Convert to a string that shows the board's state.
     */
    public String toString() {
        String boardString = "\t-------------\n\t| " + board[0][0]
                + " | " + board[0][1] + " | " + board[0][2]
                + " |\n\t-------------\n\t| " + board[1][0]
                + " | " + board[1][1] + " | " + board[1][2]
                + " |\n\t------------\n\t| " + board[2][0] + " | " + board[2][1]
                + " | " + board[2][2] + " |\n\t-------------";

        return boardString;
    }

    /**
     * Get the entry of the board at column i, row j.  Both indices should
     * be in the range [0, 2].
     */
    public char get(int i, int j) {
        if(i < 0 || i > 2 || j < 0 || j > 2){
            throw new UnsupportedOperationException("Board <get> method called with invalid indices.");
        }
        return board[i][j];
    }
    
    /**
     * @return true if there remain no empty spots on the board.
     */
    public boolean isFull() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == empty) {
                    return false;
                }
            }
        }
        return true;
    }
}
