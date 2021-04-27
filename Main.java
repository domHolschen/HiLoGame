import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String args[]) {
        boolean isUserPlaying = true; //sentinel value
        while (isUserPlaying) {
            int guessInt = 0, randomnum = 0, guessCount = 0;
            Scanner input = new Scanner(System.in);
            Random rand = new Random();
            randomnum = rand.nextInt(100)+1;
            System.out.println("Welcome to the guessing game!");
            while (true) {
                System.out.println("Please enter an integer from 1-100 or 'quit' to exit.");
                String guess = input.nextLine();
                if (guess.equals("quit")) { //sets sentinel value of outer loop to false & breaks the inner loop so it essentially exits both loops
                    isUserPlaying = false;
                    break;
                }
                guessInt = Integer.parseInt(guess); //converts guess string into an int and stores it
                System.out.println("\n\nYou guessed "+guessInt);
                guessCount++;
                if (guessInt > randomnum) System.out.println("Too high!");
                if (guessInt < randomnum) System.out.println("Too low!");
                if (guessInt == randomnum) {
                    if (guessCount == 1) {
                        System.out.println("You got it in one try! Amazing! Treat yourself to a cookie."); //special message if you get it first try
                    } else {
                        System.out.println("Wow! That was the number! You got it in "+guessCount+" guesses!"); //if it takes more than 1 guess then this displays
                    }
                    System.out.println("Press enter to play again, otherwise type 'quit'.");
                    guess = input.nextLine();
                    if (guess.equals("quit")) isUserPlaying = false;
                    break; //goes back to the start of the outer loop to reset the game
                }
            }
        }
        System.out.println("Thanks for playing!");
    }
}