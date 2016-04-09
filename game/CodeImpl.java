package game;

import pegs.BlackPeg;
import pegs.Peg;
import pegs.WhitePeg;

import java.util.*;

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
	public Set<Peg> getUnique() {

		Iterator i = pegs.iterator();
		Set<Peg> s = new HashSet<>();

		while(i.hasNext()) {
			s.add((Peg) i.next());
		}

		return s;

	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (Peg p : pegs) {

			sb.append(p.getCode());

		}

		return sb.toString();

	}

	@Override
	public String toCodeString() {


		StringBuilder sb = new StringBuilder();
		int counter = 1;

		for (Peg p : pegs) {

			sb.append("Peg: " + counter + " = " + p.getCode() + "\n");
			counter++;

		}

		return sb.toString();
	}
	
	@Override
	public Code getFeedback(String guess){
		
		Code feedback = new CodeImpl();
		String secret = this.toString();
		Map<Character, Integer> guessMap = new HashMap();
		
		int numWhite = 0;
		
		//map each peg and number of occurances in guess
		for (Character ch : guess.toCharArray()) {
			
			if (guessMap.containsKey(ch)){
				guessMap.put(ch, guessMap.get(ch) + 1);
			} else {
				guessMap.put(ch, new Integer(1));				
			}

		}
		
		//iterate through secret code, if peg is in right black, add black
		// if peg is wrong place but in map, add white
		// decrement map value in either case
		for (int i = 0; i < secret.length(); i++){
			
			char thisChar = secret.charAt(i);
			
			if(guessMap.containsKey(thisChar)){
				
				if(thisChar == guess.charAt(i)){	
					feedback.addPeg(new BlackPeg());
				} else if(guessMap.get(thisChar) > 0){	
					feedback.addPeg(new WhitePeg());
				}
				
				guessMap.put(thisChar, guessMap.get(thisChar) - 1);
			}
				
		}
		
		return feedback;
	}


}
