package co.com.reto.choucair.page;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageHome {

    private WebDriver driver;

    public PageHome(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//*[@class='']//*[contains(text(),'StartSharp')]")
    @CacheLookup
    private WebElement text_Valid_Home;

    @FindBy(how = How.ID, using = "s-sidebar-toggler")
    @CacheLookup
    private WebElement button_menu;

    public WebElement getText_Valid_Home() {
        return text_Valid_Home;
    }
    public WebElement getButton_menu() {
        return button_menu;
    }


    public WebElement getItemProFeatures(int itemProFeatures) {
        return driver.findElement(By.xpath("//*[@id='nav_menu1_3']/li["+itemProFeatures+"]/a"));
    }

    public WebElement getSelectProFeatures(int selectProFeatures) {
        return driver.findElement(By.xpath("//*[@id='nav_menu1_3_1']/li["+selectProFeatures+"]/a"));
    }


    public static final Target VALID_TEXT = Target.the("Valida el texto de la pantalla home")
            .located(By.xpath("//*[@id='s_sidebar_group1']/h5"));

    public static final Target MENU_BTN = Target.the("clic boton menu")
            .located(By.id("s-sidebar-toggler"));

    public static final Target ITEM_PRO_FEATURES_BTN = Target.the("clic boton organizacion")
            .located(By.xpath("//span[contains(.,'Organization')]"));

    public static final Target SELECT_PRO_FEATURES_BTN = Target.the("clic boton unidades de negocios")
            .located(By.xpath("//span[contains(.,'Business Units')]"));
}
