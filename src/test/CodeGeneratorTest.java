package test;


import game.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Basil on 14/02/2016.
 */
public class CodeGeneratorTest {

    private List<PegType> pegs;

    @Before
    public void buildUp(){
        pegs = new ArrayList<>();
        pegs.add(PegType.YELLOW);
        pegs.add(PegType.BLUE);
        pegs.add(PegType.GREEN);
        pegs.add(PegType.WHITE);
        pegs.add(PegType.RED);
    }

    @After
    public void tearDown(){

    }

    @Test
    public void generatesAllCharacters(){

        CodeGenerator cg = new CodeGeneratorImpl(12, pegs);

        Code code = cg.getCode();
        System.out.println(code.toString());
    }

}
