package com.tahir.automation.base;

import com.tahir.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
// import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        String browser = ConfigReader.get("browser", "chrome");
        String appUrl = ConfigReader.get("url");

        if (browser == null) {
            throw new RuntimeException("Browser not configured in config.properties");
        }

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();

            // disable password save/leak UI
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_leak_detection_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // extra flags to be sure
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-features=PasswordSaving,PasswordLeakDetection");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_leak_detection_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-features=PasswordSaving,PasswordLeakDetection");

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);

        } else {
            throw new RuntimeException("Unsupported browser in config.properties: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        if (appUrl == null) {
            throw new RuntimeException("url not configured in config.properties");
        }
        driver.get(appUrl);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
