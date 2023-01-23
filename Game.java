/**
 * Represents the logic of the game in terms of detecting wins or draws. Also
 * places new pieces for the human player or AI.
 */

public class Game {
    private Board board = new Board();
    private GameStatus status;
    private AI ai;
    private char playerPiece;
    private char aiPiece;

    public Game(boolean playerIsX, boolean challenging) {
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

    public Board getBoard() {
        return board;
    }

    public GameStatus getStatus() {
        return status;
    }

    private boolean playerWon(char playerPiece) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board.get(i,0) == playerPiece && board.get(i,1) == playerPiece && board.get(i,2) == playerPiece) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board.get(0,i) == playerPiece && board.get(1,i) == playerPiece && board.get(2,i) == playerPiece) {
                return true;
            }
        }
        // Check diagonals
        if (board.get(0,0) == playerPiece && board.get(1,1) == playerPiece && board.get(2,2) == playerPiece) {
            return true;
        }
        if (board.get(0,2) == playerPiece && board.get(1,1) == playerPiece && board.get(2,0) == playerPiece) {
            return true;
        }
        return false;
    }

    private void updateStatus(char piece){
        if(playerWon(piece) && piece == 'X'){status = GameStatus.X_WON;}
        if(playerWon(piece) && piece == 'O'){status = GameStatus.O_WON;}
        if(board.isFull()){status = GameStatus.DRAW;}
    }
    
    /**
     * Place a piece for the player on the board.
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     * range and the corresponding cell is empty.
     * @precondition status == IN_PROGRESS
     */
    public boolean placePlayerPiece(int i, int j) {

        if(i < 0 || i > 2 || j < 0 || j > 2){return false;}

        if(board.get(i, j) != board.getEmptyChar()){
            return false;
        } else{
            Move move = new Move(i, j, playerPiece);
            board = new Board(board, move);
            updateStatus(playerPiece);
            return true;
        }
    }



    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() {
        Move move = ai.chooseMove(board);
        board = new Board(board, move);
        updateStatus(aiPiece);
    }
}
