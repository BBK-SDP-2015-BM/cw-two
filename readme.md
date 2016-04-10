Mastermind
SDP Coursework 2
Contributors:
Caleb Clayton - GitHub account: claytoncaleb and BBK-PiJ-2014-51
Basil Mason - GitHub account: BasilMason


This our fully functional Mastermind implementation.

Dependency Injection is supplied by the Spring Framework. The path of the beans.xml file must be specified in Mastermind.java

To add a new peg, extend the peg class with a short implementation, specifying the colour.
e.g.

public class RedPeg extends Peg {
	public RedPeg() {
		super.colour = "Red";
	}
}


You should then add the pegs you want to play the next game with to beans.xml.
e.g.

<property name="pegList">
    <list>
       <value>Blue</value>
       <value>Green</value>
       <value>Orange</value>
       <value>Purple</value>
       <value>Red</value>
       <value>Yellow</value>
    </list>
</property>

Secret code is shown by default. To hide, comment appropriate line from MastermindDriver.java or pass True as first command line argument.
