package game;

import pegs.Peg;

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


}
