package de.klimek.jbehave_examples;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

/** Base story class that controls the report logging for all subclasses. */
@RunWith(JUnitReportingRunner.class)
public abstract class LoggingStory extends JUnitStory {

    public LoggingStory() {
        configuredEmbedder().embedderControls()
            .doVerboseFailures(true)
            .doGenerateViewAfterStories(false);
        JUnitReportingRunner.recommandedControls(configuredEmbedder());
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(new StoryReporterBuilder()
                    .withFormats(Format.IDE_CONSOLE)
                    .withCodeLocation(CodeLocations.codeLocationFromPath("build/jbehave")));
    }

}