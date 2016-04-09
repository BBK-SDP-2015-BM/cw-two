package game;

public interface GuessHistory {
	
	/**
	 * Adds a guess to guesses
	 * @param theFeedback 
	 */
	public void addGuess(String guess, Code theFeedback);
	
	/**
	 * Prints previous guesses
	 */
	public void printGuesses();
	
	/**
	 * Clears guesses
	 */
	public void clearGuesses();
	
}
