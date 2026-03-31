import java.util.Random;
import java.util.Scanner;

enum HandSign {
    ROCK, 
    PAPER,
    SCISSORS 
}

public class RPSApp {
    /**
     * Get the computer’s move (randomly generated)
     */
    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        
        HandSign computerMove = null; 

        // code using n to select
        // a HandSign
        switch (n) {
            case 0:
                computerMove = HandSign.ROCK;
                break;
            case 1:
                computerMove = HandSign.PAPER;
                break;
            case 2:
                computerMove = HandSign.SCISSORS;
                break;
        }

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove() {
        // The Scanner class is used to get the keyboard input
        Scanner in = new Scanner(System.in);
        // Use a variable to tag if the input is valid 
        // (one of the characters {s,S,p,P,r,R,q,Q}) or not
//        String playerMove = in.nextLine();
//        playerMove = playerMove.toLowerCase();

//        switch (playerMove) {
//            case "s":
//            case "p":
//            case "r":
//            case "q":
//                break;
//            default:
//                throw new AssertionError();
//        }
        boolean validInput = false;
        HandSign playerHandSign = null;
        do {// repeat until valid input

            // Add your code to give some description about what input the
            //  users are supposed to give
            System.out.println("Input 'r' for rock, 'p' for paper, 's' for scissors or 'q' to quit");

            // convert the input string into a char type
            char inChar = in.next().toLowerCase().charAt(0);

            // Add your code to output the player’s hand sign. A
            //switch-statement is a good choice.
        
            switch (inChar) {
                case 'r':
                    System.out.println("Player chose ROCK");
                    playerHandSign = HandSign.ROCK;
                    validInput = true;
                    break;
                case 'p':
                    System.out.println("Player chose PAPER");
                    playerHandSign = HandSign.PAPER;
                    validInput = true;
                    break;
                case 's':
                    System.out.println("Player chose SCISSORS");
                    playerHandSign = HandSign.SCISSORS;
                    validInput = true;
                    break;
                case 'q':
                    System.out.println("Player chose to QUIT");
//                    validInput = true;
                    return null;
                default:
                    System.out.println("Invalid input, try again.");
                    validInput = false;
            }


        } while(!validInput);
        
        return playerHandSign;

      }

    /**
     * Check who wins
     *
     * @param h1 the first hand sign
     * @param h2 the second hand sign
     * @return 0 if two signs equal, 
     *        -1 if the second sign wins, 
     *         1 if the first sign wins
     *
     */
    public static int whoWins(HandSign h1, HandSign h2){
        int win = 0;
        switch (h1) {
            case ROCK:
                switch (h2) {
                    case ROCK:
                        win = 0;
                        break;
                    case PAPER:
                        win = -1;
                        break;
                    case SCISSORS:
                        win = 1;
                        break;
                }
                break;
            case PAPER:
                switch (h2) {
                    case ROCK:
                        win = 1;
                        break;
                    case PAPER:
                        win = 0;
                        break;
                    case SCISSORS:
                        win = -1;
                        break;
                }
                break;
            case SCISSORS:
                switch (h2) {
                    case ROCK:
                        win = -1;
                        break;
                    case PAPER:
                        win = 1;
                        break;
                    case SCISSORS:
                        win = 0;
                        break;
                }
                break;
        }
        return win;
    }
    
    /**
     * The main method
     */
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;

        HandSign playerMove = null;// player’s sign from keyboard
        HandSign computerMove;// computer’s random sign

        int checkwin;
        boolean gameOver = false;
        while (!gameOver){
            // repeat this process till the user quits
            
            //Step1: Get the player move from the keyboard input
            try {
                playerMove = getPlayerMove();
            } catch (NullPointerException e) {
                System.out.println("### Exception name: " + e.getClass().getName());
                System.out.println("### Error message: " + e.getMessage());
            }
            //Step2: Get the computer’s move (randomly generated)
            computerMove = getComputerMove();
            //Step3: Check who wins
            checkwin = whoWins(playerMove, computerMove);
            //Step4: Output who played what and who won the round
            String winner = "";
            switch (checkwin) {
                case 0:
                    winner = "draw";
                    break;
                case 1:
                    winner = "player wins";
                    playerScore ++;
                    break;
                case -1:
                    winner = "computer wins";
                    computerScore ++;
                    break;
            }
            System.out.println("Player played: " + playerMove + ", Computer played: " + computerMove + ". The result of the round is: " + winner);
            //Step5: Update and print player/computer scores
            System.out.println("Player score: " + playerScore + ". Computer score: " + computerScore);
        }
    }
}