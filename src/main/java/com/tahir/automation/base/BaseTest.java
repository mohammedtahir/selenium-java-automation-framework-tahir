package com.tahir.automation.base;

import com.tahir.automation.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {

        // ✅ Correct method usage
        String browser = ConfigReader.get("browser", "chrome");
        String appUrl  = ConfigReader.get("url");

        if (appUrl == null || appUrl.isEmpty()) {
            throw new RuntimeException("❌ url not configured in config.properties");
        }

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // ✅ Speed + stability fixes
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");

            WebDriverManager.chromedriver().clearDriverCache().setup();
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-extensions");

            WebDriverManager.edgedriver().clearDriverCache().setup();
            driver = new EdgeDriver(options);

        } else {
            throw new RuntimeException("❌ Unsupported browser: " + browser);
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        // ✅ Navigation
        driver.get(appUrl);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
