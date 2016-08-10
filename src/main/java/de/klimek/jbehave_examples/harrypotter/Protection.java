package de.klimek.jbehave_examples.harrypotter;

public class Protection extends Spell {
    
    public Protection(String name) {
        super(name);
    }
    
    public boolean protectsAgainst(Spell spell) {
        // protects against everything
        return true;
    }

}
