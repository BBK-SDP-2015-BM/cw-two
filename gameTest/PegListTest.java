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


public class PegListTest {
	
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPegLoad() {
		
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("file:/Users/caleb/Desktop/sdp/cw-two/src/game/Beans.xml");

	    GameBeans pegList = (GameBeans) context.getBean("GameBeans");
	    
	    List<String> pegs = pegList.getPegList();
	    for(String peg: pegs){
	    	System.out.println(peg.toString());
	    }
		
	}
	
	@Test
	public void test(){
		assertEquals(0,0);
	}
	
	

}
