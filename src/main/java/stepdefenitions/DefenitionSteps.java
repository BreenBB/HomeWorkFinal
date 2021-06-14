package stepdefenitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefenitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    PageFactoryManager pageFactoryManager;
    ElectronicsPage electronicsPage;
    ComputersCatalogPage computersCatalogPage;
    GraphicCardsCatalogPage graphicCardsCatalogPage;
    CartPage cartPage;
    SearchPage searchPage;
    ItemPage itemPage;
    SellerPage sellerPage;
    ChromeOptions ops = new ChromeOptions();

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User checks SignIn text visibility")
    public void userChecksSignInTextVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.checkWhatSignInTextIsPresent());
    }

    @When("User clicks on SignIn button")
    public void userClicksOnSignInText() {
        homePage.clickOnSignInText();
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getLoginField());
    }


    @And("User enters {string} in the login field")
    public void userEntersLoginInTheLoginField(final String login) {
        signInPage.enterLoginInLoginField(login);
    }

    @And("User press continue button")
    public void userPressContinueButton() {
        signInPage.clickOnContinueButton();
    }

    @And("User enters {string} in the password field")
    public void userEntersDhtvtyysqInThePasswordField(final String password) {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getPasswordField());
        signInPage.enterPasswordInPasswordField(password);
    }

    @And("User press SignIn button")
    public void userPressSignInButton() {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getSignInButton());
        signInPage.clickOnSignInButton();
        homePage = pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getLoggedButton());
    }

    @When("User checks what login was successful")
    public void userChecksWhatLoginWasSuccessful() {
        assertTrue(homePage.getLoggedButton().isDisplayed());
    }

    @And("User clicks on logged menu")
    public void userCheckOnLoggedMenu() {
        homePage.clickOnLoggedText();
    }

    @And("User clicks on LogOut button")
    public void userClickOnLogOutButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getLogOutButton());
        homePage.clickOnLogOutText();
    }

    @Then("User checks that oops message is displayed")
    public void userChecksThatOopsMessageIsDisplayed() {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,signInPage.getSignInOopsMessage());
        assertTrue(signInPage.getSignInOopsMessage().isDisplayed());
    }

    @And("User checks Electronics tab visibility")
    public void userChecksElectronicsTabVisibility() {
        assertTrue(homePage.getElectronicsTab().isDisplayed());
    }

    @When("User clicks on Electonics Tab")
    public void userClicksOnElectonicsTab() {
        homePage.clickElectronicsTab();
        electronicsPage = pageFactoryManager.getElectronicsPage();
        electronicsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        electronicsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks Computers Catalog visibility")
    public void userChecksComputersCatalogVisibility() {
        assertTrue(electronicsPage.getComputersCategory().isDisplayed());
    }

    @And("User clicks on Computers Catalog Tab")
    public void userClicksOnComputersCatalogTab() {
        electronicsPage.clickComputersCategory();
        computersCatalogPage = pageFactoryManager.getComputersCatalogPage();
        computersCatalogPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        computersCatalogPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @When("User checks Computer Components DropDown list")
    public void userChecksComputerComponentsDropDownList() {
        assertTrue(computersCatalogPage.getComponentsDropDownList().isDisplayed());
    }

    @And("User clicks on Components DropDown list")
    public void userClicksOnComponentsDropDownList() {
        computersCatalogPage.clickComponentsDropDownList();
    }

    @And("User checks Graphics Cards visibility")
    public void userChecksGraphicsCardsVisibility() {
        computersCatalogPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,computersCatalogPage.getGraphicsCardsCatalogButton());
        assertTrue(computersCatalogPage.getGraphicsCardsCatalogButton().isDisplayed());
    }

    @And("User clicks on Graphics Cards Tab")
    public void userClicksOnGraphicsCardsTab() {
        computersCatalogPage.clickGraphicsCardsCatalogButton();
        graphicCardsCatalogPage = pageFactoryManager.getGraphicCardsCatalogPage();
        graphicCardsCatalogPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        graphicCardsCatalogPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User sets minimum price {float} and maximum {float} and press Enter")
    public void userSetsMinimumPriceAndMaximumAndPressEnter(float min, float max) {
        graphicCardsCatalogPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,graphicCardsCatalogPage.getMinimumPriceValueField());
        graphicCardsCatalogPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,graphicCardsCatalogPage.getMaximumPriceValueField());
        graphicCardsCatalogPage.enterMinimumPriceValue(String.valueOf(min));
        graphicCardsCatalogPage.enterMaximumPriceValue(String.valueOf(min));
        graphicCardsCatalogPage.pressEnter();
    }

    @Then("User checks what prices off all goods are within selected range of {float} and {float}")
    public void userChecksWhatPricesOffAllGoodsAreWithinSelectedRange(float min, float max) {
        graphicCardsCatalogPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        graphicCardsCatalogPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        int count = graphicCardsCatalogPage.getItemPriceList().size();
        boolean priceIsWithinRange=true;
        for (int i = 0; i < count; i++) {
            if (graphicCardsCatalogPage.getItemPrice(i)<min||graphicCardsCatalogPage.getItemPrice(i)>max) {
                priceIsWithinRange=false;
                break;
            }
        }
        Assert.assertTrue(priceIsWithinRange);
    }

    @And("User sets {string} filter tag")
    public void userSetsAMDFilterTag(String tag) {
        graphicCardsCatalogPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        graphicCardsCatalogPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        int count = graphicCardsCatalogPage.getSideFiltersList().size();
        for (int i = 0; i < count; i++) {
            if (graphicCardsCatalogPage.getSideFilterText(i)==tag) {
                graphicCardsCatalogPage.clickOnSideFilterElement(i);
                break;
            }
        }
    }

    //sadly none of item elements contains any of tags in them like brand or such
    @Then("User checks what filtering result is {string}")
    public void userChecksWhatFilteringResultIsAMDGBMemory(String tags) {
        graphicCardsCatalogPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        graphicCardsCatalogPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        graphicCardsCatalogPage.checkFiltersInAddress(tags);
    }

    @And("User clicks on sorting selection list")
    public void userClicksOnSortingSelectionList() {
        graphicCardsCatalogPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        graphicCardsCatalogPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        graphicCardsCatalogPage.hoverOnSortingMenu();
    }

    @And("User selects sorting from highest price")
    public void userSelectsSortingFromHighestPrice() {
        graphicCardsCatalogPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, graphicCardsCatalogPage.getSortingButtonByHighestPrice());
        graphicCardsCatalogPage.clickSortingButtonByHighestPrice();
    }

    @Then("User checks what items are sorted in descension order incorrectly")
    public void userChecksWhatItemsAreSortedInDescensionOrderIncorrectly() {
        graphicCardsCatalogPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        graphicCardsCatalogPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        int count = graphicCardsCatalogPage.getItemPriceList().size();
        boolean priceInDescendingOrder=true;
        for (int i = 1; i < count; i++) {
            if (graphicCardsCatalogPage.getItemPrice(i-1)<graphicCardsCatalogPage.getItemPrice(i)) {
                priceInDescendingOrder=false;
                break;
            }
        }
        Assert.assertTrue(!priceInDescendingOrder);
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        Assert.assertTrue(homePage.getSearchInput().isDisplayed());
        Assert.assertTrue(homePage.getSearchButton().isDisplayed());
    }

    @And("User enters {string} in the search field")
    public void userEntersTeddyBearInTheSearchField(String input) {
        homePage.enterSearchButton(input);
    }

    @When("User clicks on search button")
    public void userClicksOnSearchButton() {
        homePage.clickOnSearchButton();
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks what result contains {string}")
    public void userChecksWhatResultContainsTeddyBear(String input) {
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        int count = searchPage.getSearchResultList().size();
        boolean searchHasTeddyBear=true;
        for (int i = 1; i < count; i++) {
            if (!searchPage.getSearchResult(i).getText().toLowerCase().contains(input.toLowerCase())) {
                searchHasTeddyBear=false;
                break;
            }
        }
        Assert.assertTrue(searchHasTeddyBear);
    }

    @Then("User checks the not found message")
    public void userChecksTheNotFoundMessage() {
        Assert.assertTrue(searchPage.getMessageNotFound().isDisplayed());
        Assert.assertEquals(searchPage.getMessageNotFound().getText(),"No exact matches found");
    }

    @Then("User checks that result is all categories page instead of search page")
    public void userChecksThatResultIsAllCategoriesPageInsteadOfSearchPage() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.ebay.com/n/all-categories");
    }

    @Then("User clicks on first found item in search menu")
    public void userClicksOnFirstFoundItemInSearchMenu() {
        searchPage.clickOnSearchResult(0);
        itemPage = pageFactoryManager.getItemPage();
        itemPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        itemPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User adds item to cart")
    public void userAddsItemToCart() {
        itemPage.clickOnAddToCartButton();
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks what item is added to cart")
    public void userChecksWhatItemIsAddedToCart() {
        Assert.assertTrue(cartPage.getItemElement().isDisplayed());
    }

    @And("User removes item from cart")
    public void userRemovesItemFromCart() {
        cartPage.clickOnRemoveItemButton();
    }

    @Then("User checks what item are removed from cart")
    public void userChecksWhatItemAreRemovedFromCart() {
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getNoItemsMessage());
        Assert.assertTrue(cartPage.getNoItemsMessage().isDisplayed());
    }

    @And("User clicks on first found item in catalog")
    public void userClicksOnFirstFoundItemInCatalog() {
        graphicCardsCatalogPage.clickOnProduct(0);
        itemPage = pageFactoryManager.getItemPage();
        itemPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        itemPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks on seller profile link")
    public void userClicksOnSellerProfileLink() {
        itemPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, itemPage.getSellerLink());
        itemPage.clickOnSellerLink();
        sellerPage = pageFactoryManager.getSellerPage();
        sellerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sellerPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks on seller item for sale link")
    public void userClicksOnSellerItemForSaleLink() {
        sellerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, sellerPage.getItemsForSaleLink());
        sellerPage.clickOnItemsForSaleLink();
        sellerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sellerPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks what link have item list")
    public void userChecksWhatLinkHaveItemList() {
        sellerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, sellerPage.getProduct(0));
        Assert.assertTrue(sellerPage.getProduct(0).isDisplayed());
    }

    @And("User clicks on seller feedback link")
    public void userClicksOnSellerFeedbackLink() {
        sellerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, sellerPage.getFeedbackLink());
        sellerPage.clickOnFeedbackLink();
        sellerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sellerPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);

    }

    @Then("User checks what feedback page is opened and have feedback ratings element")
    public void userChecksWhatFeedbackPageIsOpenedAndHaveFeedbackRatingsElement() {
        sellerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, sellerPage.getFeedbackHeader());
        Assert.assertTrue(sellerPage.getFeedbackHeader().isDisplayed());
    }

    @And("User hover mouse on view selection drop down")
    public void userHoverMouseOnViewSelectionDropDown() {
        graphicCardsCatalogPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,graphicCardsCatalogPage.getListViewMenu());
        graphicCardsCatalogPage.hoverOnListViewMenu();
    }

    @And("User selects view by list")
    public void userSelectsViewByList() {
        graphicCardsCatalogPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,graphicCardsCatalogPage.getListViewToList());
        graphicCardsCatalogPage.clickOnListViewToList();
        graphicCardsCatalogPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        graphicCardsCatalogPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);

    }

    @Then("User checks what items sorted in vertical list instead of grid-like gallery view")
    public void userChecksWhatItemsSortedInVerticalListInsteadOfGridLikeGalleryView() {
        Assert.assertFalse(graphicCardsCatalogPage.getParentElementOfItemList().getAttribute("class").contains("srp-grid"));
    }
}
