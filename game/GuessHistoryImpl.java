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
		guesses.add(guess + ": " + theFeedback.toString());
	}

	@Override
	public void printGuesses() {
		int guessCounter = 0;
		
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
