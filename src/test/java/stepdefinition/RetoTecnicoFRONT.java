package stepdefinition;


import co.com.reto.choucair.data.objects.DTONameBusinessUnit;
import co.com.reto.choucair.helpers.TestInfo;
import co.com.reto.choucair.page.PageBussinesUnit;
import co.com.reto.choucair.page.PageHome;
import co.com.reto.choucair.page.PageLogin;
import co.com.reto.choucair.taskBussines.BusinessControllerWeb;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RetoTecnicoFRONT {
    private BusinessControllerWeb businessControllerWeb;
    List<DTONameBusinessUnit> obtenerInformacionDeTodaslasUnidadesDeNegocio;
    private TestInfo testInfo;
    private PageLogin pageLogin;
    private PageHome pageHome;
    private PageBussinesUnit pageBussinesUnit;
    private WebDriver driver;

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^usuario se autentica en el aplicativo StarSharp \"([^\"]*)\" \"([^\"]*)\"$")
    public void usuario_se_autentica_en_el_aplicativo_StarSharp(String escenario, String funcionalidad)   {
        TestInfo testInfo = new TestInfo(escenario,funcionalidad);
        businessControllerWeb = new BusinessControllerWeb(driver);
        businessControllerWeb.abrirBrowser();
        businessControllerWeb.autenticacionStarSharp();
        businessControllerWeb.validarPaginaHome();
    }

    @When("^realiza creacion de una unidad de negocio$")
    public void realiza_creacion_de_una_unidad_de_negocio()   {
        businessControllerWeb.ingresaAlMenu();
        businessControllerWeb.validarPaginaBusinessUnits();
        businessControllerWeb.crearUnidadDeNegocio();

    }

    @Then("^guarda y valida que se haya creado con exito$")
    public void guarda_y_valida_que_se_haya_creado_con_exito()   {
        businessControllerWeb.guardaUnidadDeNegocio();
        businessControllerWeb.validarRegistroUnidadDeNegocio();
        businessControllerWeb.obtenerInformacionDeTodaslasUnidadesDeNegocio();
    }

    @When("realiza programacion de una nueva reunion")
    public void realiza_programacion_de_una_nueva_reunion() {
        businessControllerWeb.ingresaAlMenuReuniones();
        businessControllerWeb.programarReunion();


    }
    @Then("guarda y valida que se haya creado con exito la reunion")
    public void guarda_y_valida_que_se_haya_creado_con_exito_la_reunion() {
        businessControllerWeb.guardaReunion();
    }




    @After
    public void finalizar() {
        businessControllerWeb.cerraBrowser();

    }


}
