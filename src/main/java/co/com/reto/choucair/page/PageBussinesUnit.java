package co.com.reto.choucair.page;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageBussinesUnit {

    private WebDriver driver;
    public PageBussinesUnit(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//*[@class='title-text']")
    @CacheLookup
    private WebElement text_valid_BussinesUnits;

    @FindBy(how = How.XPATH, using = "//*[@id='GridDiv']/div[2]/div[2]/div/div/div[1]/div")
    @CacheLookup
    private WebElement button_New_Bussines_unit;

    @FindBy(how = How.NAME, using = "Name")
    @CacheLookup
    private WebElement input_name;

    @FindBy(how = How.ID, using = "select2-chosen-3")
    @CacheLookup
    private WebElement button_select_parent_unit;

    @FindBy(how = How.XPATH, using = "//*[@class='slick-cell l1 r1']")
    @CacheLookup
    private List<WebElement> listSelect;

    @FindBy(how = How.XPATH, using = "//*[@class='tool-button save-and-close-button icon-tool-button']")
    @CacheLookup
    private WebElement button_Salve_close;

    public WebElement getText_valid_BussinesUnits() { return text_valid_BussinesUnits;   }
    public WebElement getButton_New_Bussines_unit() { return button_New_Bussines_unit;   }
    public WebElement getInput_name() { return input_name;   }
    public WebElement getButton_select_parent_unit() { return button_select_parent_unit;   }
    public List<WebElement> getListSelect() { return listSelect;   }
    public WebElement getButton_Salve_close() { return button_Salve_close;   }

    public WebElement getItemBussinesUnit(String item) {
        return driver.findElement(By.linkText("//*[@class='slick-cell l1 r1']//*[contains(text(),'"+item+"')]"));
    }


    public static final Target VALID_TEXT_BUSINESS_UNIT = Target.the("Valida el texto de la pantalla unidades de negocio")
            .located(By.xpath("//*[@id='GridDiv']/div[1]/div"));

    public static final Target NEW_BUSINESS_UNIT_BTN = Target.the("clic para agregar una unidad de negocio")
            .located(By.xpath("//*[@id='GridDiv']/div[2]/div[2]/div/div/div[1]/div"));

    public static final Target NAME_INPUT = Target.the("agregar nombre")
            .located(By.name("Name"));

    public static final Target BUSINESS_UNIT_LIST_DOWN = Target.the("clic desplegar la lista")
            .located(By.xpath("//span[contains(.,'--select--')]"));

    public static final Target BUSINESS_UNIT_SELECT_LIST_DOWN = Target.the("clic Y selecciona una unidad de negocio")
            .located(By.xpath("//*[@class='select2-results-dept-0 select2-result select2-result-selectable'][10]"));


    public static final Target SALVE_CLOSE_BTN = Target.the("clic guardar y cerrar")
            .located(By.xpath("//*[@class='tool-button save-and-close-button icon-tool-button']"));

    public static final Target VALID_BUSINESS_UNIT = Target.the("valida que se encuentre la unidad de negocio que fue creada anteriormente")
            .located(By.xpath("//a[contains(.,'Test01')]"));

}
