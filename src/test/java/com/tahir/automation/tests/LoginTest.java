package com.tahir.automation.tests;

import com.tahir.automation.base.BaseTest;
import com.tahir.automation.pages.LoginPage;
import com.tahir.automation.pages.MainPage;
import com.tahir.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Open Salesforce and perform login using config values")
    public void verifyValidLogin() {
        String url = ConfigReader.get("url");
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");

        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
            
        }
    }

    @Test(priority = 2, description = "Verify page title after login (checks if logged in)")
    public void verifyPageTitleAfterLogin() {
        String expectedTitle = ConfigReader.get("expectedTitle");
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Login failed or page title mismatch!");
    }

    @Test(priority = 3, description = "Navigate and add product")
    public void GotoProduct() throws InterruptedException {
        String productName = ConfigReader.get("productsName");
        MainPage main = new MainPage(driver);
        main.clickProductByName(productName);
        Thread.sleep(8000);
    }


}