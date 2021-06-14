package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@id='srp-river-results']//a[@class='s-item__link']")
    List<WebElement> searchResultList;

    @FindBy(xpath = "//h3[contains(text(),'No exact matches found')]")
    WebElement messageNotFound;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMessageNotFound() {
        return messageNotFound;
    }

    public List<WebElement> getSearchResultList() {
        return searchResultList;
    }

    public WebElement getSearchResult(int i) {
        return searchResultList.get(i);
    }

    public void clickOnSearchResult(int i){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getSearchResult(i).click();
    }
}
