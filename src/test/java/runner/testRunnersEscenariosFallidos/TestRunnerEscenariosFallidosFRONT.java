package runner.testRunnersEscenariosFallidos;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "@target/escenariosFallidosTestRunnerDescargaPlanilla.txt"
                            }
        , glue = {"java/stepdefinition"}
        , plugin = {"pretty", "html:target/cucumber", "json:target/TestRunnerEscenariosFallidosFRONT.json"})
public class TestRunnerEscenariosFallidosFRONT {
}
