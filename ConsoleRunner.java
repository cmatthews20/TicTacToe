/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 */

import java.util.Scanner;

public class ConsoleRunner {

    private boolean playerIsX;
    private boolean isChallenging;
    private Game game;
    private Board gameBoard;
    private String gameBoardString;
    private GameStatus gameStatus;
    private int hCoordInput;
    private int vCoordInput;
    private String playerInput = "";
    private String challengeInput = "";
    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    public ConsoleRunner() {    
        /*
         * Uses 'next' method of Scanner and the 'matches' of the String
         * class to process user responses as strings.
         */
        
        System.out.println("Do you want to play as X (Y/N): ");
        playerInput = scanner.nextLine();
        playerInput = playerInput.toUpperCase();
        playerIsX = playerInput.matches("Y");
    
        System.out.println("Do you want a challenge (Y/N): ");
        challengeInput = scanner.nextLine();
        challengeInput = challengeInput.toUpperCase();
        isChallenging = challengeInput.matches("Y");
        
        game = new Game(playerIsX, isChallenging);
    }

    private void printCurrentBoard(){
        gameBoard = game.getBoard();
        gameBoardString = gameBoard.toString();
        System.out.println(gameBoardString);
    }

    private boolean gameIsOver(){
        gameStatus = game.getStatus();
        if(gameStatus == GameStatus.X_WON){System.out.println("X WINS!"); return true;}
        if(gameStatus == GameStatus.O_WON){System.out.println("O WINS!"); return true;}
        if(gameStatus == GameStatus.DRAW){System.out.println("DRAW!"); return true;}
        return false;
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
         // 'nextInt' method of Scanner class used to read user responses as ints

         if(!playerIsX){
            game.aiPlacePiece();
            System.out.println("After AI move: ");
            printCurrentBoard();
         }

         while(game.getStatus() == GameStatus.IN_PROGRESS){

            System.out.println("Enter desired vertical coordinate: ");
            hCoordInput = scanner.nextInt();

            System.out.println("Enter desired horizontal coordinate: ");
            vCoordInput = scanner.nextInt();

            boolean moveCompleted = game.placePlayerPiece(hCoordInput, vCoordInput);

            if(!moveCompleted){
                System.out.println("Invalid Entry. Try again.");
                continue;
            }
            
            System.out.println("After your move: ");
            printCurrentBoard();
            if(gameIsOver()){break;}
            
            game.aiPlacePiece();

            System.out.println("After AI move: ");
            printCurrentBoard();
            if(gameIsOver()){break;}
        }
    }
}
