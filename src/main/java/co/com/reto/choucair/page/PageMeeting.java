package co.com.reto.choucair.page;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PageMeeting {

    public static final Target NEW_MEETING_BTN = Target.the("clic para agregar una reunion")
            .located(By.xpath("//span[contains(.,'New Meeting')]"));

    public static final Target MEETING_NAME_INPUT = Target.the("nombre de la reunion")
            .located(By.name("MeetingName"));

    public static final Target MEETING_NUMBER_INPUT = Target.the("numero de telefono")
            .located(By.name("MeetingNumber"));

    public static final Target LIST_DOWN_MEETING_TYPE = Target.the("desplegar la lista tipo de reunion")
            .located(By.id("select2-chosen-342"));
    public static final Target SELECT_MEETING_TYPE = Target.the("seleccionar la lista tipo de reunion")
            .located(By.xpath("//*[@id='select2-results-342']/li[4]"));

    public static final Target MEETING_DATE_START_INPUT = Target.the("fecha inicio")
            .located(By.name("StartDate"));

    public static final Target MEETING_DATE_END_INPUT = Target.the("fecha fin")
            .located(By.name("EndDate"));

    public static final Target LIST_DOWN_LOCATION = Target.the("desplegar la lista de locaciones")
            .located(By.id("select2-chosen-7"));
    public static final Target SELECT_LOCATION = Target.the("seleccionar la lista de locaciones")
            .located(By.xpath("//*[@id='select2-results-7']/li[4]"));

    public static final Target LIST_DOWN_UNIT = Target.the("desplegar la lista de unidades")
            .located(By.id("select2-chosen-8"));
    public static final Target SELECT_UNIT = Target.the("seleccionar la lista de unidades")
            .located(By.xpath("//*[@class='select2-results-dept-0 select2-result select2-result-selectable'] //*[contains(.,'Technology » Test')]"));

    public static final Target LIST_DOWN_ORGANIZED = Target.the("desplegar la lista de organizado por")
            .located(By.id("select2-chosen-9"));
    public static final Target SELECT_ORGANIZED = Target.the("seleccionar la lista de organizado por")
            .located(By.xpath("//*[@id='select2-results-9']/li[5]"));

    public static final Target LIST_DOWN_REPORTER = Target.the("desplegar la lista de reporte")
            .located(By.id("select2-chosen-10"));
    public static final Target SELECT_REPORTER = Target.the("seleccionar la lista de reporte")
            .located(By.xpath("//*[@id='select2-results-10']/li[5]"));

    public static final Target LIST_DOWN_ATTENDEE_LIST = Target.the("desplegar la lista de aistentes")
            .located(By.id("select2-chosen-12"));
    public static final Target SELECT_ATTENDEE_LIST = Target.the("seleccionar la lista de aistentes")
            .located(By.xpath("//*[@id='select2-results-12']/li[7]"));

    public static final Target MEETING_SALVE_CLOSE_BTN = Target.the("clic guardar y cerrar")
            .located(By.xpath("//span[contains(.,'Save')]"));


}
