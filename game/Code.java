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

	/**
	 * Adds peg to code
	 * @param peg peg to add
	 */
    public void addPeg(Peg peg);
    
    /**
     * Gets set of pegs in code
     */
    public Set<Peg> getUnique();
    
    /**
     * Gets code as a string
     * @return code as string
     */
    public String toCodeString();
    
    /**
     * Gets black/white pegs as feedback
     * @param guess to check
     * @return code of white/black pegs
     */
    public Code getFeedback(String guess);

}
