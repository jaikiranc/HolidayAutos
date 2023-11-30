
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/Features"},
                 glue = "ui.stepDefination",
                 plugin = {"pretty","html:target/cucumber-report.html"},
		                            monochrome = true)
public class CucumberTest {

}
