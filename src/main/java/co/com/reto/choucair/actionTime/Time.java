package co.com.reto.choucair.actionTime;

import co.com.reto.choucair.helpers.Constant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Time implements Interaction {
    private Target target;

    public Time(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        /**Esta clase es de esperas implicitas*/
        WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Constant.SHORT);
        wait.until(ExpectedConditions.elementToBeClickable(target.resolveFor(actor)));
    }

    public static Time oflElement(Target target) {
        return Tasks.instrumented(Time.class, target);
    }

    public static void waiting(int waiting) {
        try {
            Thread.sleep(Long.parseLong(String.valueOf(waiting)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}