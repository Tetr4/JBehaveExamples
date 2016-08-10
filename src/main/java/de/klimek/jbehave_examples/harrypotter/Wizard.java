package de.klimek.jbehave_examples.harrypotter;

public class Wizard extends LivingCreature {

    public Wizard(String name) {
        super(name);
    }

    public void cast(Spell spell, LivingCreature target) {
        target.getHitBy(spell);
    }

}
