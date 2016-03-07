package game;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pegs.Peg;

public class GameImpl extends GameAbstractImpl {
	
	private int numGuesses = 12;
	private int guesses = 0;
	
	private Code theCode = null;
	private List<Peg> pegs = null;

	public GameImpl(Boolean easy) {
		super(easy);
		
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("file:/Users/caleb/Desktop/sdp/cw-two/src/game/Beans.xml");

	    GameBeans pegList = (GameBeans) context.getBean("GameBeans");
	    
	    
	    List<String> pegNames = pegList.getPegList();
	    pegs = new ArrayList();
	    
	    for(String peg: pegNames){
	    	//System.out.println(peg.toString());
	    	try {
				pegs.add((Peg) Class.forName(peg+"Peg").newInstance());
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	    
	}

	@Override
	public void runGames() {
		showIntro();
		generateCode();
		while (guesses == numGuesses){
			
			
		}
		
	}

	private void generateCode() {
		CodeGenerator cg = new CodeGenerator(5, pegs);
	    theCode = cg.getCode();
	}

	private void showIntro() {
		System.out.println("Intro.");
		
	}

}
