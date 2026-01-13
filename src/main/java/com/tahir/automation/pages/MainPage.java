package com.tahir.automation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public WebDriver driver;

    // Locators
    @FindBy(id = "twotabsearchtextbox")
    private WebElement SearchBox;
    
    @FindBy(id = "nav-search-submit-button")
    private WebElement SearchSubmit;

     @FindBy(className =  "a-dropdown-container")
    private WebElement sortbyCN;


    // Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
   
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
        // Implementation for clicking on a specific product
    }
}