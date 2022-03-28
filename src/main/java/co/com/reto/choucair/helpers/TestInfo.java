package co.com.reto.choucair.helpers;


import io.cucumber.java.Scenario;

public class TestInfo {


    private Scenario scenario;
    private String scenarioName;
    private String scenarioFolder;
    private String ambiente;
    private String featureFolder;


    public TestInfo(Scenario scenario) {
        this.scenario = scenario;
        this.scenarioName = scenario.getName();
        this.scenarioFolder = scenario.getName().toUpperCase().replace(" ","_");
        this.ambiente = scenario.getSourceTagNames().stream().filter(sourceTag -> sourceTag.startsWith("@Ambiente:"))
                .findFirst().orElse("@Ambiente:Pruebas").replace("@Ambiente:", "").toLowerCase();
        this.featureFolder = scenario.getSourceTagNames().stream().filter(sourceTag -> sourceTag.startsWith("@CarpetaFeature:"))
                .findFirst().orElse("@CarpetaFeature:Pruebas").replace("@CarpetaFeature:", "");
    }

    public TestInfo(String funcionalidad, String escenario) {
        this.scenarioFolder = escenario;
        this.featureFolder = funcionalidad;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getFeatureFolder() {
        return featureFolder;
    }

    public void setFeatureFolder(String featureFolder) {
        this.featureFolder = featureFolder;
    }

    public String getScenarioFolder() {
        return scenarioFolder;
    }

    public void setScenarioFolder(String scenarioFolder) {
        this.scenarioFolder = scenarioFolder;
    }
}
