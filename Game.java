/**
 * Represents the logic of the game in terms of detecting wins or draws. Also
 * places new pieces for the human player or AI.
 */

public class Game {
    private Board board = new Board();
    private GameStatus status;
    private AI ai;
    public char playerPiece;
    public char aiPiece;

    /*
     * TBD: Additional private members?
     */

    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {
        /*
         * TBD
         
         */

         status = GameStatus.IN_PROGRESS;

        if(challenging){
            ai = new SmartAI(!playerIsX);
        } else{
            ai = new DumbAI(!playerIsX);
        }

        if(playerIsX){
            playerPiece = 'X';
            aiPiece = 'O';
        } else{
            playerPiece = 'O';
            aiPiece = 'X';
        }
    }

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
        return status;
    }
    
    /**
     * Place a piece for the player on the board.
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     * range and the corresponding cell is empty.
     *
     * @precondition status == IN_PROGRESS
     *
     */
    public boolean placePlayerPiece(int i, int j) {
        /*
         * TBD
         */

        if(status == GameStatus.IN_PROGRESS){
            Move move = new Move(i, j, playerPiece);
            board = new Board(board, move);
            return true;
        } else{
            return false;
        }

        //TODO update status



        

    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() {
        /*
         * TBD
         */
        Move move = ai.chooseMove(board);
        board = new Board(board, move);
    }
}
