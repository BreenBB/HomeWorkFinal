package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public ElectronicsPage getElectronicsPage() {
        return new ElectronicsPage(driver);
    }

    public ComputersCatalogPage getComputersCatalogPage() {
        return new ComputersCatalogPage(driver);
    }

    public GraphicCardsCatalogPage getGraphicCardsCatalogPage() {
        return new GraphicCardsCatalogPage(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }

    public ItemPage getItemPage() {
        return new ItemPage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

    public SellerPage getSellerPage() {
        return new SellerPage(driver);
    }
}