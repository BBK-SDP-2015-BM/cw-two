package game;

/**
 * Created by Basil on 14/02/2016.
 */
public abstract class GameAbstractImpl implements Game {
    // if showCode is true then the secret code is revealed before
    // the gane starts. This will be used by graders of the program
    // to test the feedback of guesses
    protected boolean showCode;

    /**
     * Create a Game object.
     *
     * @param easy If easy is true the secret code will be
     *             revealed at all times when playing the game. If easy is
     *             false the secret code is not revealed until correctly guessed
     *             or the player runs out of turns.
     */
    public GameAbstractImpl(boolean easy) {
        showCode = easy;
    }

}
