package com.tahir.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;

    // Locators
    @FindBy(className = "inventory_item_name")
    private List<WebElement> products;



    // Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
   
public void clickProductByName(String productName) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("productName must not be null/empty");
        }

        // for (WebElement p : products) {
            // String text = productName.getText();
            // if (text != null && text.trim().equalsIgnoreCase(productName.trim())) {
                productName.click();
            //     return;
            // }
        }
        // fallback: try contains match
        for (WebElement p : products) {
            String text = p.getText();
            if (text != null && text.toLowerCase().contains(productName.toLowerCase().trim())) {
                p.click();
                return;
            }
        }
        throw new RuntimeException("Product not found on page: ");
    }


}
