Mastermind
SDP Coursework 2
by Caleb Clayton and Basil Mason


This our fully functional Mastermind implementation.

Dependency Injection is supplied by the Spring Framework.

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
