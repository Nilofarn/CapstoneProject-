package tek.sdet.framework.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		tags ="@Test5",
        features = "classpath:features", 
        glue = "tek.sdet.framework",
        dryRun = false,
        plugin = { 
        		"pretty",
		        "html:target/htmlReports/cucumber-pretty.html", 
		        "json:target/jsonReports/cucumber.json" 
		},
        snippets = CAMELCASE,
        monochrome = true

        )

public class TestRunner {

}
