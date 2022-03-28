package runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/retoPracticoFRONT.feature"}
        , glue = {"stepdefinition"}
        , plugin = {"pretty", "html:target/cucumber", "json:target/TestRunnerRetoPracticoFRONT.json"
        , "rerun:target/escenariosFallidosTestRunnerRetoPracticoFRONT.txt"})
public class TestRunnerRetoPracticoFRONT {
}
