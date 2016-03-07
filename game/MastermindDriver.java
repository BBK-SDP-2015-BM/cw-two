package game;

/**
 * Created by Basil on 14/02/2016.
 */
public class MastermindDriver {

    // Example - change as you need to...
    public static void main(String[] args) {
        Game g = Factory.getInstance(GameImpl.class, true);
        g.runGames();

        g = Factory.getInstance(GameImpl.class, false);
        g.runGames();
    }
}
