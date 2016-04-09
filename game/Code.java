package game;

import pegs.Peg;

import java.util.Set;

/**
 * Created by Basil & Caleb on 14/02/2016.
 *
 * Code is a wrapper class for some collection of pegs.
 *
 */
public interface Code {

    void addPeg(Peg peg);
    Set<Peg> getUnique();

}
