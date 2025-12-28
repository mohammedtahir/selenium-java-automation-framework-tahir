package com.tahir.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public WebDriver driver;

    // Locators
    // @FindBy(className = "inventory_item_name")
    // private WebElement inventory;
    


    // Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
   
public void clickProductByName(String productName) {
        // if (productName == null || productName.isEmpty()) {
        //     throw new IllegalArgumentException("productName must not be null/empty");
        // }
        WebElement product = driver.findElement(By.xpath("//*[@class='inventory_item_name '][text()='" + productName + "']"));
        product.click();

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
        wait.until(d -> d.findElement(By.xpath("//button[@id='add-to-cart']")));

    }


}
