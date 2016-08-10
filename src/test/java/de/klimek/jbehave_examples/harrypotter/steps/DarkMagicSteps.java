package de.klimek.jbehave_examples.harrypotter.steps;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;

import de.klimek.jbehave_examples.harrypotter.HarryPotterContext;
import de.klimek.jbehave_examples.harrypotter.LivingCreature;
import de.klimek.jbehave_examples.harrypotter.Protection;

public class DarkMagicSteps {
	
    private HarryPotterContext context;

    public DarkMagicSteps(HarryPotterContext context) {
        this.context = context;
    }

    @Given("$personName has $quantity horcruxes")
    @Alias("$personName has $quantity horcrux")
    public void associateHorcrux(String personName, int quantity) {
        LivingCreature entity = context.getEntityByName(personName);
        for (int i = 0; i < quantity; i++) {
            entity.addProtection(new Protection("horcrux"));
        }
    }

}