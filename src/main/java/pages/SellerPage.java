package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SellerPage extends BasePage {

    @FindBy(xpath = "//span[@class='soi_lk fl']")
    private WebElement itemsForSaleLink;

    @FindBy(xpath = "//a[@class='vip']")
    private List<WebElement> productList;

    @FindBy(xpath = "//span[@class='all_fb fr']")
    private WebElement feedbackLink;

    @FindBy(xpath = "//span[@data-test-id='rating-header']")
    private WebElement feedbackHeader;

    public SellerPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getItemsForSaleLink() {
        return itemsForSaleLink;
    }
    public void clickOnItemsForSaleLink() {
        itemsForSaleLink.click();
    }

    public List<WebElement> getProductList() {
        return productList;
    }
    public WebElement getProduct(int i) {
        return productList.get(i);
    }

    public WebElement getFeedbackLink() {
        return feedbackLink;
    }
    public void clickOnFeedbackLink() {
        feedbackLink.click();
    }
    public boolean checkFeedbackAddress() {
        return driver.getCurrentUrl().contains("feedback_profile");
    }
    public WebElement getFeedbackHeader() {
        return feedbackHeader;
    }
}
