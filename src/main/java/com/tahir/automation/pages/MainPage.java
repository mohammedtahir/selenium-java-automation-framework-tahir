package com.tahir.automation.pages;

import java.time.Duration;
import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public WebDriver driver;

    // Locators
    @FindBy(id = "nav-link-accountList")
    private WebElement NavToSignIn;

    @FindBy(className  = "nav-action-inner")
    private WebElement FloatingSignIn;
    
    @FindBy(id = "ap_email_login")
    private WebElement EmailorPhone;

    @FindBy(className  = "a-button-input")
    private WebElement ContinueButton;

    @FindBy(id = "ap_password")
    private WebElement PwdField;

    @FindBy(id = "signInSubmit")
    private WebElement FinalSignInButton;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement SearchBox;
    
    @FindBy(id = "nav-search-submit-button")
    private WebElement SearchSubmit;

     @FindBy(className =  "a-dropdown-container")
    private WebElement sortbyCN;

    @FindBy(xpath =  "//span[@id='submit.add-to-cart-announce']")
    private WebElement AddToCartButton;

    @FindBy(id = "wishListMainButton")
    private WebElement AddToWishlistButton;

    @FindBy(id  = "huc-view-your-list-button")
    private WebElement ViewYourListButton;

    @FindBy(id = "itemName_I11PTUNO0CNEMT")
    private WebElement ClickOnTheProduct;


    // Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions

    public void OpenAmazonAndLogin(String username, String password) {
        // Implementation for login can be added here if needed
        Actions actions = new Actions(driver);
        actions.moveToElement(NavToSignIn).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signInButton = wait.until(
        ExpectedConditions.elementToBeClickable(FloatingSignIn));
        signInButton.click();

        EmailorPhone.sendKeys(username);
        ContinueButton.click();
        PwdField.sendKeys(password);
        FinalSignInButton.click();
    }
   
public void SearchProductByName(String productName) {
        SearchBox.sendKeys(productName);
        SearchSubmit.click();
    }

public void SortProductBy(String SortBy) {
        sortbyCN.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sortDropdown = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("s-result-sort-select")));
        Select sortdropDown = new Select(sortDropdown);
        sortdropDown.selectByVisibleText(SortBy);
    }

    public void ClickOnTheProduct(String ProductToBeClicked) {
        //click on the product with name passed from config file and new tab will be opened and switch to that tab

        By productLocator = By.xpath("//span[contains(text(), '" + ProductToBeClicked + "')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(productLocator));
        productElement.click();
        // Switch to the new tab
        List<String> tabs = List.copyOf(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void AddProductToWishlist() {
        // Implementation for adding product to wishlist can be added here if needed
        AddToWishlistButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewListButton = wait.until(
        ExpectedConditions.elementToBeClickable(ViewYourListButton));
        viewListButton.click();
    }

    public void AddProductToCart() throws InterruptedException {
        AddToCartButton.click();
        Thread.sleep(10000);

    }

    public void verifyProductAddedToWishlist(String wishlistProduct) {
        // Implementation for verifying product added to wishlist can be added here if needed
        String wishlistProductName01 = ClickOnTheProduct.getText();
        System.out.println("Product added to wishlist: " + wishlistProductName01);    
        wishlistProductName01.equals(wishlistProduct);
    }

    // public void TakeScreenshot(String fileName) {
    //     // Implementation for taking screenshot can be added here if needed
    //     // ScreenshotUtil.takeScreenshot(driver, fileName);
    //     TakeScreenshot(fileName);   

    // }
}