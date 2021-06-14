package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends BasePage {

    @FindBy(xpath = " //a[@class='b-visualnav__tile b-visualnav__tile__default']//div[contains(text(),'Computers, Tablets & Network Hardware')]")
    WebElement computersCategoryButton;

    public ElectronicsPage(WebDriver driver) {
        super(driver);
    }

    public void clickComputersCategory() {
        computersCategoryButton.click();
    }
    public WebElement getComputersCategory() {
        return computersCategoryButton;
    }
}
