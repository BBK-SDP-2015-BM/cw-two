package game;

import java.util.List;

/**
 * Created by Basil & Caleb on 14/02/2016.
 *
 * CodeGenerator class randomly generates a code of given length using a valid character set
 */
class CodeGenerator {

    protected Code theCode;
    private int length;
    private List<PegImpl> pegs;

    public CodeGenerator(int length, List<PegType> pegs){
        this.length = length;
        this.pegs = pegs;
        setCode();
    }

    public Code getCode(){
        return theCode;
    }

    private void setCode() {

        for (int i = 0; i < length; i++) {

            int pick = (int) (Math.random() * pegs.size());

            theCode.addPeg(new PegImpl(pegs.get(pick)));

        }

    }

}
