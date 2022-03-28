package co.com.reto.choucair.taskBussines;


import co.com.reto.choucair.data.objects.DTONameBusinessUnit;
import co.com.reto.choucair.helpers.AssertExceptions;
import co.com.reto.choucair.helpers.Constant;
import co.com.reto.choucair.helpers.ManagerLog;
import co.com.reto.choucair.page.PageBussinesUnit;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static co.com.reto.choucair.page.PageBussinesUnit.*;
import static co.com.reto.choucair.page.PageHome.*;
import static co.com.reto.choucair.page.PageLogin.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class BusinessControllerWeb {

    private static final String LOG_CLASE = "BusinessControllerWeb -> ";
    private static final String OCURRIO_ERROR_NAVEGADOR_OPEN = " Ocurrió un error al abrir el navegador: ";
    private static final String OCURRIO_ERROR_NAVEGADOR_CLOSE = " Ocurrió un error al cerrar el navegador: ";
    private static final String MENSAJE_FALLO_GENERAL = "Ocurrió un error: ";

    private final WebDriver driver;

    public BusinessControllerWeb(WebDriver driver) {
        this.driver = driver;
    }


    public void abrirBrowser(){
        final String METODO = "openBrowser -> ";
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Constant.PATH_CONFIGURATION_PROPERTIES)));
            String appURL = (String) properties.get("DemoUrl");
            theActorCalled(Constant.ACTOR).attemptsTo(Open.url(appURL));

            ManagerLog.imprimirExito("Se abrio el navegador web");
        }catch (Exception e){
            ManagerLog.imprimirFallo(LOG_CLASE + METODO + OCURRIO_ERROR_NAVEGADOR_OPEN +  AssertExceptions.getErrorStackTrace(e));
        }
    }

   public void cerraBrowser(){
       final String METODO = "closeBrowser -> ";
       try{
           BrowseTheWeb.as(theActorCalled(Constant.ACTOR)).getDriver().close();
           ManagerLog.imprimirExito("Se cerro el navegador web");
       }catch (Exception e){
           ManagerLog.imprimirFallo(LOG_CLASE + METODO + OCURRIO_ERROR_NAVEGADOR_CLOSE +  AssertExceptions.getErrorStackTrace(e));
       }
   }

   public void autenticacionStarSharp(){
       final String METODO = "autenticacionStarSharp -> ";
        try{
                /**
           PageLogin pageLogin = new PageLogin();

            Time.waiting(Constant.SHORT);
            pageLogin.getInput_usuario().clear();
            pageLogin.getInput_password().clear();
            pageLogin.getInput_usuario().sendKeys("admin");
            pageLogin.getInput_password().sendKeys("serenity");
*/
            Actor actor = theActor(Constant.ACTOR);
            actor.attemptsTo(
                    WaitUntil.the(USER_INPUT, isVisible()).forNoMoreThan(Constant.SHORT).seconds(),
                    Clear.field(USER_INPUT),Clear.field(PASSWORD_INPUT),
                    Enter.theValue("admin").into(USER_INPUT),
                    Enter.theValue("serenity").into(PASSWORD_INPUT),
                    WaitUntil.the(INICIAR_SESION_BTN, isVisible()).forNoMoreThan(Constant.SHORT).seconds(),
                    Click.on(INICIAR_SESION_BTN));
            ManagerLog.imprimirExito( "el usuario se autentica exitosamente");

        }catch (Exception e){
            ManagerLog.imprimirFallo(LOG_CLASE + METODO + MENSAJE_FALLO_GENERAL +  AssertExceptions.getErrorStackTrace(e));
        }
   }

   public void validarPaginaHome() {
       final String METODO = "validarPaginaHome -> ";
       try {
           Actor actor = theActor(Constant.ACTOR);
           actor.attemptsTo(
                   WaitUntil.the(VALID_TEXT, isVisible()).forNoMoreThan(Constant.SHORT).seconds());
           ManagerLog.imprimirExito(Constant.ANDROIDE + " Visualiza el texto del home");
       } catch (Exception e) {
           ManagerLog.imprimirFallo(LOG_CLASE + METODO + MENSAJE_FALLO_GENERAL + "al validar el texto de la pagina home" + AssertExceptions.getErrorStackTrace(e));
       }

   }

   public void ingresaAlMenu() {
       final String METODO = "ingresaAlMenu -> ";
       try {
           Actor actor = theActor(Constant.ACTOR);
           actor.attemptsTo(
                   WaitUntil.the(ITEM_PRO_FEATURES_BTN, isVisible()).forNoMoreThan(Constant.SHORT).seconds(),
                   Click.on(ITEM_PRO_FEATURES_BTN),
                   Click.on(SELECT_PRO_FEATURES_BTN));
           ManagerLog.imprimirExito( "el usuario se autentica exitosamente");
       } catch (Exception e) {
           ManagerLog.imprimirFallo(LOG_CLASE + METODO + MENSAJE_FALLO_GENERAL + "seleccionar las opciones del menu" + AssertExceptions.getErrorStackTrace(e));
       }
   }

    public void validarPaginaBusinessUnits() {
        final String METODO = "validarPaginaBusinessUnits -> ";
        try {
            Actor actor = theActor(Constant.ACTOR);
            actor.attemptsTo(
                    WaitUntil.the(VALID_TEXT_BUSINESS_UNIT, isVisible()).forNoMoreThan(Constant.SHORT).seconds());
            ManagerLog.imprimirExito(Constant.ANDROIDE + " Visualiza el texto");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + METODO + MENSAJE_FALLO_GENERAL + "al validar el texto de la pagina home" + AssertExceptions.getErrorStackTrace(e));
        }
    }

    public void crearUnidadDeNegocio() {
        final String METODO = "crearUnidadDeNegocio -> ";
        try {
            Actor actor = theActor(Constant.ACTOR);
            actor.attemptsTo(
                    WaitUntil.the(NEW_BUSINESS_UNIT_BTN, isVisible()).forNoMoreThan(Constant.SHORT).seconds(),
                    Click.on(NEW_BUSINESS_UNIT_BTN),
                    Enter.theValue("Test Test Test").into(NAME_INPUT));
            actor.attemptsTo(
                    Click.on(BUSINESS_UNIT_LIST_DOWN),
                    Click.on(BUSINESS_UNIT_SELECT_LIST_DOWN));
            ManagerLog.imprimirExito( "el usuario crea con exito la unidad de negocio");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + METODO + MENSAJE_FALLO_GENERAL + "seleccionar y crear la unidades de neogocio" + AssertExceptions.getErrorStackTrace(e));
        }
    }

    public void guardaUnidadDeNegocio() {
        final String METODO = "guardaUnidadDeNegocio -> ";
        try {
            Actor actor = theActor(Constant.ACTOR);
            actor.attemptsTo(Click.on(SALVE_CLOSE_BTN));
            ManagerLog.imprimirExito( "el usuario guarda con exito la unidad de negocio");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + METODO + MENSAJE_FALLO_GENERAL + "al guardar la unidad de negocio" + AssertExceptions.getErrorStackTrace(e));
        }
    }

    public List<DTONameBusinessUnit> obtenerInformacionDeTodaslasUnidadesDeNegocio() {
        final String METODO = LOG_CLASE + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> ";
        List<DTONameBusinessUnit> dtoVerNameBusinessUnitList = new ArrayList<>();
        PageBussinesUnit pageBussinesUnit = new PageBussinesUnit(driver);
        try {
            for (int i = 0; i < pageBussinesUnit
                    .getListSelect().size() ; i++) {
                DTONameBusinessUnit dtoNameBusinessUnit = new DTONameBusinessUnit();
                dtoNameBusinessUnit.setNameBusinessUnit(pageBussinesUnit
                        .getListSelect().get(i).getText());
                dtoVerNameBusinessUnitList.add(dtoNameBusinessUnit);
            }
            return dtoVerNameBusinessUnitList;
        } catch (Exception e) {
            ManagerLog.imprimirFallo(METODO + MENSAJE_FALLO_GENERAL +  " Al obtener los datos de los registros de las unidades de negocio");
            return Collections.emptyList();
        }
    }

}
