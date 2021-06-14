package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//a[@data-test-id='cart-item-link']")
    WebElement itemElement;

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    WebElement removeItemButton;

    @FindBy(xpath = "//span[contains(text(),'have any items in your cart.')]")
    WebElement noItemsMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getItemElement() {
        return itemElement;
    }

    public WebElement getRemoveItemButton() {
        return removeItemButton;
    }
    public void clickOnRemoveItemButton() {
        removeItemButton.click();
    }

    public WebElement getNoItemsMessage() {
        return noItemsMessage;
    }
}
