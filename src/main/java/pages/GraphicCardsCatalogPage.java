package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GraphicCardsCatalogPage extends BasePage {

    @FindBy(xpath = "//input[@aria-label='Minimum Value, US Dollar']")
    WebElement minimumPriceValueField;

    @FindBy(xpath = "//input[@aria-label='Maximum Value, US Dollar']")
    WebElement maximumPriceValue;

    @FindBy(xpath = "//h3[@class='s-item__title']")
    List<WebElement> itemList;

    @FindBy(xpath = "//li[@class='s-item s-item--large s-item--bgcolored']//span[@class='s-item__price']")
    List<WebElement> itemPriceList;

    @FindBy(xpath = "//div[@class='x-refine__multi-select ']//span[@class='cbx x-refine__multi-select-cbx']")
    List<WebElement> sideFiltersList;

    @FindBy(xpath = "//div[contains(@class,'srp-controls__sort')]//button[@class='x-flyout__button']")
    WebElement sortingMenu;

    @FindBy(xpath = "//li[@class='btn']//span[contains(text(),'Price + Shipping: lowest first')]")
    WebElement sortingButtonByLowestPrice;

    @FindBy(xpath = "//li[@class='btn']//span[contains(text(),'Price + Shipping: highest first')]")
    WebElement sortingButtonByHighestPrice;

    @FindBy(xpath = "//div[contains(@class,'srp-view-options')]//button[@class='x-flyout__button']")
    WebElement listViewMenu;

    @FindBy(xpath = "//span[contains(text(),'List View')]")
    WebElement listViewToList;

    @FindBy(xpath = "//span[contains(text(),'List View')]")
    WebElement listViewToGallery;

    @FindBy(xpath = "//ul[contains(@class,'b-list__items_nofooter')]")
    WebElement parentElementOfItemList;

    public void enterMinimumPriceValue(String min) {
        minimumPriceValueField.sendKeys(min);
    }
    public void enterMaximumPriceValue(String max) {
        maximumPriceValue.sendKeys(max);
    }
    public void pressEnter() {
        maximumPriceValue.sendKeys(Keys.ENTER);
    }

    public WebElement getMinimumPriceValueField() {
        return maximumPriceValue;
    }
    public WebElement getMaximumPriceValueField() {
        return maximumPriceValue;
    }

    public List<WebElement> getItemList() {
        return itemList;
    }
    public WebElement getItem(int i) {
        return itemList.get(i);
    }

    public void clickOnProduct(int i){
        itemList.get(i).click();
    }

    public List<WebElement> getItemPriceList() {
        return itemPriceList;
    }
    public double getItemPrice(int i) {
        String price = itemPriceList.get(i).getText();
        return Double.parseDouble(price.replaceAll("[^0-9.]", ""));
    }

    public List<WebElement> getSideFiltersList() {
        return sideFiltersList;
    }
    public void clickOnSideFilterElement(int i) {
        sideFiltersList.get(i).click();
    }
    public String getSideFilterText(int i) {
        return sideFiltersList.get(i).getText();
    }
    public boolean checkFiltersInAddress(String tags) {
        return driver.getCurrentUrl().contains(tags);
    }

    public void hoverOnSortingMenu() {
        Actions builder = new Actions(driver);
        builder.moveToElement(sortingMenu).perform();
    }
    public WebElement getSortingMenu() {
        return sortingMenu;
    }

    public void clickSortingButtonByLowestPrice() {
        sortingButtonByLowestPrice.click();
    }
    public WebElement getSortingButtonByLowestPrice() {
        return sortingButtonByLowestPrice;
    }

    public void clickSortingButtonByHighestPrice() {
        sortingButtonByHighestPrice.click();
    }
    public WebElement getSortingButtonByHighestPrice() {
        return sortingButtonByHighestPrice;
    }

    public GraphicCardsCatalogPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOnListViewMenu() {
        Actions builder = new Actions(driver);
        builder.moveToElement(listViewMenu).perform();
    }
    public WebElement getListViewMenu() {
        return listViewMenu;
    }

    public void clickOnListViewToList() {
        listViewToList.click();
    }
    public WebElement getListViewToList() {
        return listViewToList;
    }

    public WebElement getParentElementOfItemList() {
        return parentElementOfItemList;
    }
}
