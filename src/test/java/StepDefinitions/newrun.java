package StepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "src/test/resources/Feature",
        monochrome = true,
        dryRun = true,
        glue = {"StepDefinitions"}
)

public class newrun {


}
