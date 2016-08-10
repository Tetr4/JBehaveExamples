package de.klimek.jbehave_examples.harrypotter;

public class CounterSpell extends Protection {
    private Spell counteredSpell;

    public CounterSpell(String name, Spell counteredSpell) {
        super(name);
        this.counteredSpell = counteredSpell;
    }

    @Override
    public boolean protectsAgainst(Spell spell) {
        return counteredSpell.equals(spell);
    }

}
