/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 */

public class Board {

    private char[][] board = new char[3][3];

    /*
     * TBD: Additional private members?
     */

    /**
     * Construct an empty board (all space chars).
     */
    public Board() {
        char empty = ' ';

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
                board[i][j] = other.board[i][j];
            }
        }

        board[move.getI()][move.getJ()] = move.getPiece();
    }

    /**
     * Convert to a string that shows the board's state.
     */
    public String toString() {
        /*
         * TBD
         */
    }

    /**
     * Get the entry of the board at column i, row j.  Both indices should
     * be in the range [0, 2].
     */
    public char get(int i, int j) {
        /*
         * TBD
         */
    }
    
    /**
     * @return true if there remain no empty spots on the board.
     */
    public boolean isFull() {
        /*
         * TBD
         */
    }
}
