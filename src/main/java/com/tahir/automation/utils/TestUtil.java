package com.tahir.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destPath = "screenshots/" + testName + "_" + timestamp + ".png";
        try {
            Files.createDirectories(new File("screenshots").toPath());
            Files.copy(srcFile.toPath(), new File(destPath).toPath());
            System.out.println("📸 Screenshot saved at: " + destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
