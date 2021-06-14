package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='mbg-nw']")
    WebElement sellerLink;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
    public void clickOnAddToCartButton() {
        Actions builder = new Actions(driver);
        builder.moveToElement(addToCartButton).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", addToCartButton);
    }

    public WebElement getSellerLink() {
        return sellerLink;
    }
    public void clickOnSellerLink() {
        Actions builder = new Actions(driver);
        builder.moveToElement(sellerLink).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", sellerLink);
    }

}
