package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//FeatureFiles\\Travel_Insurance.feature"},
		glue="StepDefinitionFiles",
		plugin= {"pretty","html:reports//CucumberReports.html",
				"json:report/MyReport.json"},
		dryRun=false,
		monochrome=true,
		publish=true
		)
public class TestRun {

}
