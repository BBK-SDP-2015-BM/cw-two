package game;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Basil on 14/02/2016.
 */
public class Mastermind extends GameAbstractImpl {
    private List<PegType> pegs;
    private int codeLength;
    private int numGuesses;
    private Scanner sc;

    /**
     * Create a Game object.
     *
     * @param easy If easy is true the secret code will be
     *             revealed at all times when playing the game. If easy is
     *             false the secret code is not revealed until correctly guessed
     *             or the player runs out of turns.
     */
    public Mastermind(boolean easy, int codeLength, List pegs, int numGuesses) {
        super(easy);
        this.pegs = pegs;
        this.numGuesses = numGuesses;
        this.codeLength = codeLength;
        openResources();

    }

    @Override
    public void runGames() {
        printInstructions();
        while(runGame());

    }

    private boolean runGame(){

        CodeGenerator cg = new CodeGeneratorImpl(codeLength, pegs);
        Code code = cg.getCode();


        while(numGuesses > 0){
            String guess = getUserGuess();

            if(code.equals(guess)){
                //you win
            } else {
                getFeedback(guess);
            }


            numGuesses--;
        }


        boolean runGame = false;
        return runGame;
    }

    private Feedback getFeedback(String guess) {
        return null;
    }

    private void printInstructions(){
        String inst = "Welcome";
        System.out.println(inst);
    }

    private String getUserGuess(){
        System.out.print("You have "+ numGuesses +" guesses left.\n" +
                "\n" +
                "What is your next guess?\n" +
                "Type in the characters for your guess and press enter.\n" +
                "Enter guess: ");
        String guess = sc.nextLine();

        while(!isValid(guess)){
            System.out.println("What is your next guess?");

            guess = sc.nextLine();
        }

        return guess;
    }

    private void openResources(){
        sc = new Scanner(System.in);
    }

    private void closeResources(Scanner sc){
        sc.close();
    }

    private boolean isValid(String guess){
        if(guess.length() != codeLength)
            return false;

        //make sure guess contains valid chars


    }


}
