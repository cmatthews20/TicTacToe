/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 */

import java.util.Scanner;

public class ConsoleRunner {

    /**
     * Should the human player be the X? X always goes first.
     */
    private boolean playerIsX;

    private boolean isChallenging;

    private Game game;
    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    /*
     * TBD: Additional private members?
     */

    /**
     * Constructor
     */
    public ConsoleRunner() {    
        /*
         * Uses 'next' method of Scanner and the 'matches' of the String
         * class to process user responses as strings.
         */
        System.out.println("Do you want to play as X (Y/N, case sensitive): ");
        String playerInput = scanner.nextLine();
        playerInput = playerInput.toUpperCase();
        playerIsX = playerInput.matches("Y"); // Case insensitive
        
        System.out.println("Do you want a challenge (Y/N, case sensitive): ");
        String challengeInput = scanner.nextLine();
        challengeInput = challengeInput.toUpperCase();
        isChallenging = challengeInput.matches("Y"); // Case insensitive
        

        game = new Game(playerIsX, isChallenging);
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
        /*
         * TBD
         *
         * Use 'nextInt' method of Scanner class to read user responses as ints
         * 
         * Private helper methods?
         */

         Board gameBoard = game.getBoard();
         String gameBoardString = gameBoard.toString();

         if(!playerIsX){
            
            game.aiPlacePiece();

            System.out.println("After AI move: ");

            gameBoard = game.getBoard();
            gameBoardString = gameBoard.toString();
            System.out.println(gameBoardString);
         }

         while(game.getStatus() == GameStatus.IN_PROGRESS){

            System.out.println("Enter desired x-coordinate: ");
            int xCoordInput = scanner.nextInt();

            System.out.println("Enter desired y-coordinate: ");
            int yCoordInput = scanner.nextInt();

            game.placePlayerPiece(xCoordInput, yCoordInput);
            
            System.out.println("After your move: ");

            
            
            System.out.println(gameBoardString);
            
            System.out.println("After AI move: ");

            game.aiPlacePiece();

            gameBoard = game.getBoard();
            gameBoardString = gameBoard.toString();
            System.out.println(gameBoardString);


            //TODO: Remove tests
            System.out.println("playerIsX: " + playerIsX);
            System.out.println("isChallenging: " + isChallenging); 
            System.out.println("Latest coordinate inputs: " + xCoordInput + ", " + yCoordInput);
            System.out.println("Current game status: " + game.getStatus());

            break;
         }
         

         
        
    }
}
