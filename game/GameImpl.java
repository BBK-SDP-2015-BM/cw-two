package game;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameImpl extends GameAbstractImpl {
	
	private int numGuesses = 12;
	private int guesses = 0;
	
	PegList pegs;

	public GameImpl(Boolean easy) {
		super(easy);
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");

	     pegs = (PegList) context.getBean("pegList");


	}

	@Override
	public void runGames() {
		showIntro();
		//generateCode();
		while (guesses < numGuesses){
			
			
		}
		
		

	}

	private void showIntro() {
		System.out.println("Intro.");
		
	}

}
