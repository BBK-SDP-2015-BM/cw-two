package pegs;

/**
 * Created by Basil on 14/02/2016.
 */
public abstract class Peg {
	protected String colour;
	
	public char getCode(){
    	return colour.charAt(0); 
    }
}
