/**
 * Realization of AI interface using simplistic random placement strategy.
 */

import java.util.Random;

public class DumbAI implements AI {
    
    private Random random = new Random();
    private char piece;
    
    public DumbAI(boolean aiIsX) {
        if (aiIsX) {
            piece = 'X';
        } else {
            piece = 'O';
        }
    }

    public Move chooseMove(Board board) {
        int i = random.nextInt(3);
        int j = random.nextInt(3);

        while(board.get(i, j) != board.getEmptyChar()){
            i = random.nextInt(3);
            j = random.nextInt(3);
        }
        Move move = new Move(i,j,piece);
        
        return move;
    }
}
