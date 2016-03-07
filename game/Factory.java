package game;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Basil on 14/02/2016.
 */
public class Factory {

    public static Game getInstance(Class c, Boolean b){
        
    	Class[] parameterTypes = new Class[1];
    	parameterTypes[0] = b.getClass();
    	Constructor cons = null;
    	Game theGame = null;
    	
    	//Constuctor[] consArr= null;
		
		try {
			cons = c.getConstructor(Boolean.class);
			
			
			theGame = (Game) cons.newInstance(b);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return theGame;
    }
}
