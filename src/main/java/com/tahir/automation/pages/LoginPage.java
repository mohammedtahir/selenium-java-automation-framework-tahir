// package com.tahir.automation.pages;

// import javax.swing.Action;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.interactions.Actions;
// import org.openqa.selenium.support.FindBy;
// import org.openqa.selenium.support.PageFactory;

// public class LoginPage {

//     public WebDriver driver;

//     // Locators
//     @FindBy(id = "ap_email_login")
//     private WebElement usernameField;

//     @FindBy(id = "password")
//     private WebElement passwordField;

//     @FindBy(id =  "login-button")
//     private WebElement loginButton;

//      @FindBy(xpath  =  "//*[@id='nav-link-accountList']/a")
//     private WebElement clktosignin;

//     @FindBy(xpath = "//div[@class='error-message']")
//     private WebElement errorMessage;

//     // Constructor
//     public LoginPage(WebDriver driver) {
//         this.driver = driver;
//         PageFactory.initElements(driver, this);
//     }

//     // 
//     public void clicktoSignIn(String clktosignin){
//         Actions actions = new Actions(driver);
//         actions.moveToElement(this.clktosignin).click().perform();
//     }

//     public void enterUsername(String username) {
//         usernameField.clear();
//         usernameField.sendKeys(username);
//     }

//     public void enterPassword(String password) {
//         passwordField.clear();
//         passwordField.sendKeys(password);
//     }

//     public void clickLogin() {
//         loginButton.click();
//     }

//     public String getErrorMessage() {
//         try {
//             return errorMessage.getText();
//         } catch (Exception e) {
//             return null;
//         }
//     }

//     // Combined action
//     public void login(String username, String password) {
//         clktosig(clktosignin);
//         enterUsername(username);
//         enterPassword(password);
//         clickLogin();
//     }
// }
