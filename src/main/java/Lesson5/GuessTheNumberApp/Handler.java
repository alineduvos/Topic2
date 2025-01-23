package Lesson5.GuessTheNumberApp;

/*
    - The server generates a random number
    - The client must guess it
    - The handler class will handle the logic/rules of the game
 */

import java.util.Random;

public class Handler {

    // State for our game
    private static final int WAITING = 0;
    private static final int GUESSING = 1;
    private static final int GAME_OVER = 2;

    // Current state of handler when starting game
    private int state = WAITING;

    // The target number (the client needs to guess this number)
    private int targetNumber;

    // Maximum number of guess the user can attempt
    private int attemptsLeft = 5;


    public Handler(){
        // Generating a random number
        Random random = new Random();
        targetNumber = random.nextInt(100)+1; // a random number between 1 and 100
    }

    public String processInput(String input){
        String output = null;

        // We haven't started
        if(state==WAITING){
            output = "Welcome to our Game!\n "
                    + "have picked a number between 1 and 100 \n"
                    + "You have "+attemptsLeft+" tries to guess it\n"
                    + "Type your guess (or 'quit' to exit)";
            state = GUESSING;
        }else if(state==GUESSING){
            // Handle client quitting the game
            if(input.equals("quit")){
                output = "Goodbye! Thanks for playing.";
                state = GAME_OVER;
            }else{
                int guess = Integer.parseInt(input);
                // Check if guess is correct, too hight, or too low
                if(guess==targetNumber){
                    output = "Congratulations! You guess correctly.\n"
                            + "Type 'quit' to exit, or 'play again' to start a new game";
                    state = GAME_OVER; // we mark the game as over
                }else{
                    attemptsLeft--;
                    if(attemptsLeft<=0){
                        output = "Sorry, you are out of attempts. The number was "+targetNumber
                                +" . Type 'play again' to start a new game or 'quit' to stop playing";
                        state = GAME_OVER;
                    }else if(guess<targetNumber){
                        output = "Too low! you have "+attemptsLeft;
                    }else{
                        output = "Too high! you have "+attemptsLeft;
                    }
                }
            }
        }else if(state==GAME_OVER){
            if(input.equals("play again")){

            }
        }

        return  output;

    }

}
