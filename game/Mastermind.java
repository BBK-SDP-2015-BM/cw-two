package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pegs.Peg;

public class Mastermind extends GameAbstractImpl {
	
	private Scanner sc;
	private int numGuesses = 12;
	private int guesses = 0;
	private int codeLength;
	private Code theCode = null;
	private List<Peg> pegs = null;
	private Map<Character, String> validPegCodes = null;

	public Mastermind(Boolean easy) {
		super(easy);
		
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("file:/Users/caleb/Desktop/sdp/cw-two/src/game/Beans.xml");

	    GameBeans pegList = (GameBeans) context.getBean("GameBeans");
	    
	    List<String> pegNames = pegList.getPegList();
	    pegs = new ArrayList();
	    validPegCodes = new HashMap();
	    codeLength = 5;
	    
	    for(String peg: pegNames){

	    	try {
				pegs.add((Peg) Class.forName("pegs."+peg+"Peg").newInstance());
				validPegCodes.put(peg.charAt(0), peg);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	}
	

	@Override
	public void runGames() {
		
		openResources();
		
		showIntro();
		generateCode();
		
		while (guesses <= numGuesses){
			
			String guess = getUserGuess();

//            if(code.equals(guess)){
//                //you win
//            } else {
//                getFeedback(guess);
//            }
            
            numGuesses++;
			
		}
		
		closeResources(sc);
		
	}

	private void generateCode() {
		CodeGenerator cg = new CodeGenerator(codeLength, pegs);
	    theCode = cg.getCode();
	}

	private void showIntro() {
		System.out.println("Intro.");
		
	}
	
	private void printInstructions() {
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

        for(int i = 0; i < guess.length(); i++) {
        	
        	if (!validPegCodes.keySet().contains(guess.charAt(i)))
        		return false;
        	
        }
        
        return true;

    }

}
