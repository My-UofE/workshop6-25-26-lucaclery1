import java.util.Scanner;
import java.util.Random;

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
        if (n.equals(0)) {
            
        }
        // a HandSign

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove(){
        // The Scanner class is used to get the keyboard input
        Scanner in = new Scanner(System.in);
        // Use a variable to tag if the input is valid 
        // (one of the characters {s,S,p,P,r,R,q,Q}) or not
        boolean validInput = true;
        HandSign playerHandSign = null;
        do {// repeat until valid input

            // Add your code to give some description about what input the
            //  users are supposed to give
            System.out.println("");

            // convert the input string into a char type
            char inChar = in.next().toLowerCase().charAt(0);

            // Add your code to output the player’s hand sign. A
            //switch-statement is a good choice.
        
            ...


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
         ...
    }
    
    /**
     * The main method
     */
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;

        HandSign playerMove;// player’s sign from keyboard
        HandSign computerMove;// computer’s random sign

        int checkwin;
        boolean gameOver = false;
        while (!gameOver){
            // repeat this process till the user quits
            
            //Step1: Get the player move from the keyboard input

            //Step2: Get the computer’s move (randomly generated)

            //Step3: Check who wins

            //Step4: Output who played what and who won the round

            //Step5: Update and print player/computer scores

        }
    }
}