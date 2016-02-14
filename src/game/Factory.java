package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Basil on 14/02/2016.
 */
public class Factory {

    public static Game getInstance(Class c, Boolean b){
        List<PegType> pegs;
        pegs = new ArrayList<>();
        pegs.add(PegType.YELLOW);
        pegs.add(PegType.BLUE);
        pegs.add(PegType.GREEN);
        pegs.add(PegType.WHITE);
        pegs.add(PegType.RED);

        return null;
    }
}
