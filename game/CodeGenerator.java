package game;

import java.util.List;

import pegs.Peg;

/**
 * Created by Basil & Caleb on 14/02/2016.
 *
 * CodeGenerator class randomly generates a code of given length using a valid character set
 */
public class CodeGenerator {

    protected Code theCode;
    private int length;
    private List<Peg> pegs;

    public CodeGenerator(int length, List<Peg> pegs){
        this.length = length;
        this.pegs = pegs;
        theCode = new CodeImpl();
        setCode();
    }

    public Code getCode(){
        return theCode;
    }
    
    public void regenerateCode(){
    	theCode = new CodeImpl();
    	setCode();
    }

    private void setCode() {

        for (int i = 0; i < length; i++) {

            int pick = (int) (Math.random() * pegs.size());

            //theCode.addPeg(new PegImpl(pegs.get(pick)));
            theCode.addPeg(pegs.get(pick));
        }

    }

}
