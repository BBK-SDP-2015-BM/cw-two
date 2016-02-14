package game;

/**
 * Created by Basil on 14/02/2016.
 *
 * Character
 */
public class PegCharacterImpl implements Peg {

    private Character character;

    public PegCharacterImpl(PegType type) {
        this.character = type.name().charAt(0);
    }

    @Override
    public String toString() {
        return character.toString();
    }
}
