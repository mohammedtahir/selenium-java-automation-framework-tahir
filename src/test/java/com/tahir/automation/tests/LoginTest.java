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

    @Test(priority = 1, description = "Search for product & Verify Page Title")
    public void GotoProduct() throws InterruptedException {
        String productName = ConfigReader.get("productsName");
        MainPage main = new MainPage(driver);
        main.SearchProductByName(productName);
        String expectedTitle2 = ConfigReader.get("expectedTitle02");
        System.out.println("Page2 Title: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), expectedTitle2, "Page2 title mismatch!");
    }

    @Test(priority = 2, description = "Sort Product By")
    public void SortProductBy() {
        String sortBy = ConfigReader.get("SortBy");
        MainPage main = new MainPage(driver);
        main.SortProductBy(sortBy);
    }
        


}