package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//a[@class='s-item__link']//h3[@class='s-item__title']")
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
        Actions builder = new Actions(driver);
        builder.moveToElement(getSearchResult(i)).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", getSearchResult(i));
    }
}
