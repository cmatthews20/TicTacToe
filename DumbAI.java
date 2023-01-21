/**
 * Realization of AI interface using simplistic random placement strategy.
 */

import java.util.Random;

public class DumbAI implements AI {
    
    private Random random = new Random();
    char piece;

    /*
     * TBD: Additional private members?
     */
    
    /**
     * Construct DumbAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public DumbAI(boolean aiIsX) {
        if (aiIsX) {
            piece = 'X';
        } else {
            piece = 'O';
        }
    }

    public Move chooseMove(Board board) {
        /*
         * TBD
         */
        int i = random.nextInt(3);
        int j = random.nextInt(3);
        Move move = new Move(i,j,piece);
        return move;
    }
}
