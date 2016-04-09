package game;

import java.util.ArrayList;
import java.util.List;

public class GuessHistoryImpl implements GuessHistory {

	private List<String> guesses = new ArrayList<>();
	private int numGuesses;
	
	public GuessHistoryImpl(int numGuesses){
		this.numGuesses = numGuesses;
	}
	
	@Override
	public void addGuess(String guess, Code theFeedback) {
		String feedbackStr = theFeedback.toString();
		
		StringBuilder feedbackVerbose = new StringBuilder();
		
		for (int i = 0; i < feedbackStr.length(); i++){
			if(feedbackStr.charAt(i) == 'B')
				feedbackVerbose.append("Black ");
			else if(feedbackStr.charAt(i) == 'W')
				feedbackVerbose.append("White ");
		}
		
		if (feedbackVerbose.toString().isEmpty())
			feedbackVerbose.append("No pegs");
		
		guesses.add(guess + ": " + feedbackVerbose);
	}

	@Override
	public void printGuesses() {
		int guessCounter = 0;
		
		System.out.println(".... Secret Code");
		
		for (int i = 0; i < guesses.size(); i++){
			System.out.println(guesses.get(i));
			guessCounter++;
		}
		
		while(guessCounter < numGuesses){
			System.out.println("....");
			guessCounter++;
		}
	}

	@Override
	public void clearGuesses() {
		guesses.clear();
	}

}
