package de.klimek.jbehave_examples.harrypotter.steps;

import org.jbehave.core.annotations.BeforeScenario;

import de.klimek.jbehave_examples.harrypotter.HarryPotterContext;

public class BeforeAndAfterSteps {
	
    private HarryPotterContext context;

    public BeforeAndAfterSteps(HarryPotterContext context) {
        this.context = context;
    }

    @BeforeScenario
    public void beforeScenarios() throws Exception {
        context.reset();
    }

}