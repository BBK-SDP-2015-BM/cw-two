package game;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pegs.BlackPeg;
import pegs.Peg;
import pegs.WhitePeg;

import java.util.*;

public class Mastermind extends GameAbstractImpl {

	private Scanner sc;
	private int numGuesses = 12;
	private int guesses = 0;
	private int codeLength;
	private boolean youWin = false;
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
				System.out.println("Peg colour " + peg + " not found. "
						+ "Ensure you have created a corresponding class with this colour.");
				e.printStackTrace();
			}
	    }

		sc = new Scanner(System.in);

	}


	@Override
	public void runGames() {

		showIntro();

		generateCode();

		while (guesses <= numGuesses && !youWin){
			String guess = getUserGuess();

            if(theCode.toString().equals(guess)){
				System.out.println("YOU WIN");
				youWin = true;
			} else {
				Code theFeedback = getFeedback(guess);
				printFeedback(theFeedback);
            }

            guesses++;
		}

	}

	private void generateCode() {
		CodeGenerator cg = new CodeGenerator(codeLength, pegs);
	    theCode = cg.getCode();
	}

	private void showIntro() {
		StringBuilder intro = new StringBuilder();

		intro.append("Welcome to Mastermind.\n\n");

		intro.append("This is a text version of the classic board game Mastermind.\n");
		intro.append("The computer will think of a secret code.\n");
		intro.append("The code consists of 4 colored pegs.\n");
		intro.append("The pegs may be one of six colors: blue, green, orange, purple, red, or yellow.\n");
		intro.append("A color may appear more than once in the code.\n\n");

		intro.append("You try to guess what colored pegs are in the code and what order they are in\n");
		intro.append("After making a guess the result will be displayed.\n");
		intro.append("A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n");
		intro.append("For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n\n");
		intro.append("Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n");
		intro.append("When entering guesses you only need to enter the first character of the color as a capital letter.\n\n");

		intro.append("You have 12 to guess the answer or you lose the game.\n");

		System.out.print(intro.toString());
	}

	private void printFeedback(Code theFeedback) {
		System.out.println("Your Feedback: " + theFeedback.toString());
	}

	private Code getFeedback(String guess) {

		Set<Character> colours = new HashSet<>();
		int index = 0;
		String s = theCode.toString();

		Code ret = new CodeImpl();

		for (char c : s.toCharArray()) {
			colours.add(c);
		}

		for (char c : guess.toCharArray()) {

			if (colours.contains(c)) {
				Peg feedback;

				// peg exists, ie at least white peg
				if (c == s.charAt(index)) {
					// code in place, ie black peg
					feedback = new BlackPeg();
				} else {
					feedback = new WhitePeg();
				}

				ret.addPeg(feedback);
			}

			index++;
		}

		return ret;
	}


    private String getUserGuess(){

		if (showCode) {
			System.out.println("Code: " + theCode.toString());
		}

        System.out.print("You have "+ (numGuesses - guesses) +" guesses left.\n" +
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
