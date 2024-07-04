package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SamsungPhonesPage extends BasePage {
    public SamsungPhonesPage (WebDriver driver) {
        super(driver);
    }
    public void applyModelYearFilter() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement modelYearCheckbox = driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[18]/ul/li[2]/span/a/span"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", modelYearCheckbox);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(modelYearCheckbox));
        modelYearCheckbox.click();
    }
    public void applyPriceFilter() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement priceSliderLower = driver.findElement(By.xpath("//*[@id=\"p_36/range-slider_slider-item_lower-bound-slider\"]"));
        WebElement priceSliderUpper = driver.findElement(By.xpath("//*[@id=\"p_36/range-slider_slider-item_upper-bound-slider\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", priceSliderLower);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        Actions action = new Actions(driver);
        action.dragAndDropBy(priceSliderLower, 50, 0).perform();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        action.dragAndDropBy(priceSliderUpper, -50, 0).perform();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"a-autoid-1\"]/span/input"));
        submit.click();
    }
    public void applyCameraFilter() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement cameraResolution = driver.findElement(By.xpath("//*[@id=\"p_n_feature_four_browse-bin/14210450031\"]/span/a/span"));
        js.executeScript("arguments[0].scrollIntoView(true);", cameraResolution);
        cameraResolution.click();
    }

    public void applyBrandFilter() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement brand = driver.findElement(By.xpath("//*[@id=\"p_123/46655\"]/span/a/span"));
        Long scrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        while (!brand.isDisplayed() && scrollPosition > 0) {
            js.executeScript("window.scrollBy(0, -100);");
            scrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        brand.click();
    }
}


