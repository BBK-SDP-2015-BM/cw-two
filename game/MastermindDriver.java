package game;

/**
 * Created by Basil on 14/02/2016.
 */
public class MastermindDriver {

	
    /**
     * Main method to start game. Uncomment or use command line to show code.
     * By default, secret code is shown.
     * 
     */
    public static void main(String[] args) {
    	
    	String secretParam = null;
 
    	if(args.length > 0){
    	   secretParam = args[0];	
    	} else {
    		secretParam = "True"; //comment or uncomment as needed. Comment out to hide secret code
    	}
    	   	
    	boolean showSecret = Boolean.parseBoolean(secretParam);
	
        Game g = Factory.getInstance(Mastermind.class, showSecret);
        g.runGames();
        
    }
}
