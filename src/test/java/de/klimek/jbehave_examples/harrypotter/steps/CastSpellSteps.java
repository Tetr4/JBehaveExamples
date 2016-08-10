package de.klimek.jbehave_examples.harrypotter.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import de.klimek.jbehave_examples.harrypotter.CounterSpell;
import de.klimek.jbehave_examples.harrypotter.HarryPotterContext;
import de.klimek.jbehave_examples.harrypotter.LivingCreature;
import de.klimek.jbehave_examples.harrypotter.Protection;
import de.klimek.jbehave_examples.harrypotter.Spell;
import de.klimek.jbehave_examples.harrypotter.Wizard;

public class CastSpellSteps {
	
    private HarryPotterContext context;

    public CastSpellSteps(HarryPotterContext context) {
        this.context = context;
    }

    @Given("a target named $targetName")
    public void defineTarget(String targetName) {
        context.addTarget(new LivingCreature(targetName));
    }

    @Given(value = "a target named $targetName blessed with $spellName", priority = 1)
    public void defineBlessedTarget(String targetName, String spellName) {
        LivingCreature target = new LivingCreature(targetName);
        target.addProtection(new Protection(spellName));
        context.addTarget(target);
    }

    @Given("$entityName that counterspells $spellFilterName")
    public void activateSpellShield(String entityName, String filterName) {
        LivingCreature entity;
        if (HarryPotterContext.isTarget(entityName)) {
            entity = new LivingCreature(entityName);
            context.addTarget(entity);
        } else if (HarryPotterContext.isWizard(entityName)) {
            Wizard wizard = new Wizard(entityName);
            context.addWizard(wizard);
            entity = wizard;
        } else {
            throw new IllegalArgumentException("Unknown entity");
        }

        if (HarryPotterContext.isAnySpell(filterName)) {
            entity.addProtection(new Protection("Counter Spell"));
        } else {
            entity.addProtection(new CounterSpell("Counter Spell", new Spell(filterName)));
        }

    }

    @When("the wizard cast the spell $spellName")
    public void cast(String spellName) {
        context.getWizard().cast(new Spell(spellName), context.getTarget());
    }

}