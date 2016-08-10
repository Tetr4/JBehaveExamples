package de.klimek.jbehave_examples.harrypotter.steps;

import org.jbehave.core.annotations.Given;

import de.klimek.jbehave_examples.harrypotter.HarryPotterContext;
import de.klimek.jbehave_examples.harrypotter.Wizard;

public class WizardSteps {

    private HarryPotterContext context;

    public WizardSteps(HarryPotterContext context) {
        this.context = context;
    }

    @Given("a wizard named $wizardName")
    public void defineCurrentWizard(String wizardName) {
        context.addWizard(new Wizard(wizardName));
    }

}