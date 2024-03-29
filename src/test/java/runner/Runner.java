package runner;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/OrangeFeature", glue={"stepdefinitions"}, monochrome=true, plugin={"pretty","html:target/HtmlReports/reports.html"})
public class Runner {

}
