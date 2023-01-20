/**
 * This is where I would put a 'smarter' AI, using a better algorithm instead of 
 * random placement (it has not been implemented yet).
 */

import java.lang.UnsupportedOperationException;

public class SmartAI implements AI {
    
    private char piece;
    
    /**
     * Construct a SmartAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is the 'X'.
     */
    public SmartAI(boolean aiIsX) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public Move chooseMove(Board board) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
