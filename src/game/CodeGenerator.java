package game;

import java.util.List;

/**
 * Created by Basil & Caleb on 14/02/2016.
 *
 * CodeGenerator class randomly generates a code of given length using a valid character set
 */
public abstract class CodeGenerator {

    protected Code theCode;
    protected int length;
    protected List<PegType> pegs;

    public CodeGenerator(int length, List<PegType> pegs){
        this.length = length;
        this.pegs = pegs;
    }

    protected CodeGenerator(){};

    public Code getCode(){
        return theCode;
    }



}
