package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Basil on 14/02/2016.
 */
public class CodeImpl implements Code {

    List<Peg> pegs = new ArrayList<>();

    public CodeImpl() {

    }



    @Override
    public void addPeg(Peg peg) {
        pegs.add(peg);
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        pegs.forEach(p -> sb.append(p.toString()));
        return sb.toString();
    }
}
