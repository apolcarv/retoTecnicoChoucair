package co.com.reto.choucair.page;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {
/**
    private WebDriver driver;

    public PageLogin(WebDriver driver){
        PageFactory.initElements(driver,this);
}
 */
    @FindBy(how = How.NAME, using = "Username")
    @CacheLookup
    private WebElement input_usuario;

    @FindBy(how = How.NAME, using = "Password")
    @CacheLookup
    private WebElement input_password;

    @FindBy(how = How.ID, using = "StartSharp_Membership_LoginPanel0_LoginButton")
    @CacheLookup
    private WebElement button_login;


    public WebElement getInput_usuario() {
        return input_usuario;
    }
    public WebElement getInput_password() {
        return input_password;
    }
    public WebElement getButton_login() {
        return button_login;
    }

    public static final Target USER_INPUT = Target.the("Usuario")
            .located(By.name("Username"));
    public static final Target PASSWORD_INPUT = Target.the("contrasena")
            .located(By.name("Password"));
    public static final Target INICIAR_SESION_BTN = Target.the("Iniciar Sesion")
            .located(By.id("StartSharp_Membership_LoginPanel0_LoginButton"));
}
