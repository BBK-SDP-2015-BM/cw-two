package game;

import java.util.List;

/**
 * Created by Basil on 14/02/2016.
 */
public class CodeGeneratorImpl extends CodeGenerator {

    public CodeGeneratorImpl(int length, List<PegType> pegs){
        super.length = length;
        super.pegs = pegs;
        super.theCode = new CodeImpl();
        setCode();
    }


    private void setCode() {

        for (int i = 0; i < length; i++) {

            int pick = (int) (Math.random() * pegs.size());

            theCode.addPeg(new PegCharacterImpl(pegs.get(pick)));

        }

    }
}
