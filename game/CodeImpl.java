package game;

import java.util.LinkedList;
import java.util.List;

import pegs.Peg;

/**
 * Created by Basil on 14/02/2016.
 */
public class CodeImpl implements Code {

    private List<Peg> pegs = new LinkedList();


	@Override
	public void addPeg(Peg peg) {
		pegs.add(peg);
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		
		for (Peg p : pegs) {
			
			sb.append("Peg: " + counter + " = " + p.getCode() + "\n");
			counter++;
			
		}
		
		return sb.toString();
	}


}
