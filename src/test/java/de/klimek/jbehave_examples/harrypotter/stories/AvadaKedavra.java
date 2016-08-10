package de.klimek.jbehave_examples.harrypotter.stories;

import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import de.klimek.jbehave_examples.LoggingStory;
import de.klimek.jbehave_examples.harrypotter.HarryPotterContext;
import de.klimek.jbehave_examples.harrypotter.steps.BeforeAndAfterSteps;
import de.klimek.jbehave_examples.harrypotter.steps.CastSpellSteps;
import de.klimek.jbehave_examples.harrypotter.steps.DarkMagicSteps;
import de.klimek.jbehave_examples.harrypotter.steps.LivingCreatureSteps;
import de.klimek.jbehave_examples.harrypotter.steps.WizardSteps;

public class AvadaKedavra extends LoggingStory {

    @Override
    public InjectableStepsFactory stepsFactory() {
        HarryPotterContext context = new HarryPotterContext();
        return new InstanceStepsFactory(configuration(),
                new BeforeAndAfterSteps(context),
                new CastSpellSteps(context),
                new DarkMagicSteps(context),
                new LivingCreatureSteps(context),
                new WizardSteps(context));
    }

}