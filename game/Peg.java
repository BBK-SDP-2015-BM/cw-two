package game;

/**
 * Created by Basil on 14/02/2016.
 */
public abstract class Peg {
	protected String colour;
	
	Peg(String colour){
		this.colour = colour;
	}
	
	char getCode(){
    	return colour.charAt(0); 
    }
}
