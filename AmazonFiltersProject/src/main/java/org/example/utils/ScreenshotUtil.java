package org.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    private WebDriver driver;
    private static final String SCREENSHOT_PATH = "screenshots/";

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
        createDirectory(SCREENSHOT_PATH);
    }

    public void takeScreenshot(String methodName) {
        // Generate a timestamped file name
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timestamp = sdf.format(new Date());
        String fileName = methodName + "_" + timestamp + ".png";

        try {
            // Take screenshot as file
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Save screenshot to the specified path
            Path targetPath = Paths.get(SCREENSHOT_PATH + fileName);
            Files.copy(screenshot.toPath(), targetPath);
            System.out.println("Screenshot saved: " + targetPath);
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    private void createDirectory(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + path);
            } else {
                System.err.println("Failed to create directory: " + path);
            }
        }
    }
}

