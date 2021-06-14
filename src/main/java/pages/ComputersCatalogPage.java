package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersCatalogPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Computer Components & Parts')]")
    WebElement componentsDropDownList;

    @FindBy(xpath = "//a[contains(text(),'Graphics/Video Cards')]")
    WebElement graphicsCardsCatalogButton;

    @FindBy(xpath = "//span[contains(text(),'Desktops & All-In-Ones')]")
    WebElement pcDropDownList;

    @FindBy(xpath = "//a[contains(text(),'PC Desktops & All-In-Ones')]")
    WebElement pcCatalogButton;

    public ComputersCatalogPage(WebDriver driver) {
        super(driver);
    }

    public void clickComponentsDropDownList() {
        componentsDropDownList.click();
    }
    public WebElement getComponentsDropDownList() {
        return componentsDropDownList;
    }

    public void clickGraphicsCardsCatalogButton() {
        graphicsCardsCatalogButton.click();
    }
    public WebElement getGraphicsCardsCatalogButton() {
        return graphicsCardsCatalogButton;
    }

    public void clickPCDropDownList() {
        pcDropDownList.click();
    }
    public WebElement getPCDropDownList() {
        return pcDropDownList;
    }

    public void clickPCCatalogButton() {
        pcCatalogButton.click();
    }
    public WebElement getPCCatalogButton() {
        return pcCatalogButton;
    }

}
