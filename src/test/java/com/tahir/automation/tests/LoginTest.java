package com.tahir.automation.tests;

import com.tahir.automation.base.BaseTest;

// import com.tahir.automation.pages.LoginPage;
import com.tahir.automation.pages.MainPage;
import com.tahir.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    // @Test(priority = 1, description = "Open Amazon and click login")
    // public void verifyValidLogin() {
    //     // String url = ConfigReader.get("url");

    //     String username = ConfigReader.get("username");
    //     String password = ConfigReader.get("password");

    //     // driver.get(url);
    //     LoginPage loginPage = new LoginPage(driver);
    //     loginPage.login(username, password);
    //     try {
    //         Thread.sleep(1000);
    //     } catch (InterruptedException e) {
            
    //         e.printStackTrace();
            
    //     }
    // }

    // @Test(priority = 1, description = "Verify page title")
    // public void verifyPageTitleAfterLogin() {
    //     String expectedTitle = ConfigReader.get("expectedTitle01");
    //     System.out.println("Page1 Title: " + driver.getTitle());
    //     Assert.assertEquals(driver.getTitle(), expectedTitle, "Page1 title mismatch!");
    // }

    @Test(priority = 1, description = "Open Amazon Home Page & Login")
    public void OpenAmazonAndLogin() {
        String url = ConfigReader.get("url");
        driver.get(url);
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");
        MainPage main = new MainPage(driver);
        main.OpenAmazonAndLogin(username, password);
    }

    @Test(priority = 2, description = "Search for product & Verify Page Title")
    public void GotoProduct() throws InterruptedException {
        String productName = ConfigReader.get("productsName");
        MainPage main = new MainPage(driver);
        main.SearchProductByName(productName);
        String expectedTitle2 = ConfigReader.get("expectedTitle02");
        System.out.println("Page2 Title: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), expectedTitle2, "Page2 title mismatch!");
    }

    @Test(priority = 3, description = "Sort Product By")
    public void SortProductBy() {
        String sortBy = ConfigReader.get("SortBy");
        MainPage main = new MainPage(driver);
        main.SortProductBy(sortBy);
    }

    @Test(priority = 4, description = "Click On The Product")
        public void ClickOnTheProduct() {
        String productToBeClicked = ConfigReader.get("ProductToBeClicked");
        MainPage main = new MainPage(driver);
        main.ClickOnTheProduct(productToBeClicked);
    }

    @Test(priority = 5, description = "Verify Product Page Title")
    public void verifyProductPageTitle() {
        String expectedProductPageTitle = ConfigReader.get("ProductPageTitle");
        System.out.println("Product Page Title: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), expectedProductPageTitle, "Product Page title mismatch!");
    }

    // @Test(priority = 6, description = "Add Product to Cart")
    // public void AddProductToCart() throws InterruptedException {
    //     MainPage main = new MainPage(driver);
    //     main.AddProductToCart();
    // }

    @Test(priority = 6, description = "Add to Wishlist")
    public void AddProductToWishlist() throws InterruptedException {
        MainPage main = new MainPage(driver);
        main.AddProductToWishlist();
    }

    @Test(priority = 7, description = "Verify Product Added to Wishlist")
    public void verifyProductAddedToWishlist() {
        String wishlistProduct = ConfigReader.get("ProductToBeClicked");
        MainPage main = new MainPage(driver);
        main.verifyProductAddedToWishlist(wishlistProduct);
        
    }


    @Test(priority = 8, description = "wait after adding to Wishlist")
    public void waitAfterAddingToWishlist() throws InterruptedException {
        Thread.sleep(10000);
    }



    // @Test(priority = 8, description = "Take Screenshot After Adding to Wishlist")
    // public void TakeScreenshotAfterAddingToWishlist() throws InterruptedException {
    //     MainPage main = new MainPage(driver);
    //     main.TakeScreenshot("AddToWishlist");
    // }

}