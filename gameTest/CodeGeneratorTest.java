package gameTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import game.CodeGenerator;
import game.Code;
import game.GameBeans;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

//import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pegs.Peg;

public class CodeGeneratorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCodes(){
		
		String[] expectedPegs = {"B", "Y"};
		
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("file:/Users/caleb/Desktop/sdp/cw-two/src/game/Beans.xml");

	    GameBeans pegList = (GameBeans) context.getBean("GameBeans");
	    
	    
	    List<String> pegNames = pegList.getPegList();
	    
	    List<Peg> pegs = new ArrayList();
	    
	    for(String peg: pegNames){
	    	//System.out.println(peg.toString());
	    	try {
				pegs.add((Peg) Class.forName("pegs."+peg+"Peg").newInstance());
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    

		CodeGenerator cg = new CodeGenerator(5, pegs);
	    Code theCode = cg.getCode();
	    
	    System.out.println(theCode.toString());
	    
	    // TODO: iterate through
		
	}

}
