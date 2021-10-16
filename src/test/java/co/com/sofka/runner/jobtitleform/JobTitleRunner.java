package co.com.sofka.runner.jobtitleform;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        features = {"src/test/resources/features/webui/jobtitle/JobTitle.feature"},
        glue = {"co.com.sofka.stepdefinition.jobtitleform.opt1"},
        tags = "not @ignore"
)
public class JobTitleRunner {
}
