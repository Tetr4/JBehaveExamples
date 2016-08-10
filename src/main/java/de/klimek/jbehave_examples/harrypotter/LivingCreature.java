package de.klimek.jbehave_examples.harrypotter;

import java.util.HashSet;
import java.util.Set;

public class LivingCreature {
    private String name;
    private boolean isAlive = true;
    private Set<Protection> protections = new HashSet<>();

    public LivingCreature(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    };

    public void addProtection(Protection protection) {
        protections.add(protection);
    }

    public void getHitBy(Spell spell) {
        for (Protection protection : protections) {
            if (protection.protectsAgainst(spell)) {
                // protected
                return;
            }
        }

        // not protected
        isAlive = false;
    }
}
