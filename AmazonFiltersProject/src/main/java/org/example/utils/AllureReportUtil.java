package org.example.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.Attachment;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AllureReportUtil {

    public AllureReportUtil() {
        createDirectory("allure-results/");
    }

    @Step("Creating test: {testName}")
    public void createTest(String testName) {
        Allure.step("Test: " + testName);
    }

    @Step("Logging pass: {details}")
    public void logPass(String details) {
        Allure.step(details, io.qameta.allure.model.Status.PASSED);
    }
    @Step("Logging fail: {details}")
    public void logFail(String details) {
        Allure.step(details, io.qameta.allure.model.Status.FAILED);
    }
    @Step("Logging info: {details}")
    public void logInfo(String details) {
        Allure.step(details);
    }
    @Attachment(value = "{description}", type = "image/png")
    public byte[] addScreenCaptureFromPath(String screenshotPath, String description) {
        try (InputStream is = new FileInputStream(screenshotPath)) {
            return is.readAllBytes();
        } catch (Exception e) {
            System.err.println("Failed to attach screenshot to report: " + e.getMessage());
            return new byte[0];
        }
    }

    private String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        return sdf.format(new Date());
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
