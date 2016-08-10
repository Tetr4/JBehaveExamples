package de.klimek.jbehave_examples.harrypotter.steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;

import de.klimek.jbehave_examples.harrypotter.HarryPotterContext;

public class LivingCreatureSteps {

	private HarryPotterContext context;

	public LivingCreatureSteps(HarryPotterContext context) {
		this.context = context;
	}

	@Then("$livingName is alive")
	@Alias("$livingName is still alive")
	public void checkIsAlive(String livingName) {
		assertTrue(livingName + " should be alive", context.getEntityByName(livingName).isAlive());
	}

	@Then("$livingName is dead")
	@Alias("$livingName is suddenly dead")
	public void checkIsDied(String livingName) {
		assertFalse(livingName + " should be dead", context.getEntityByName(livingName).isAlive());
	}

}