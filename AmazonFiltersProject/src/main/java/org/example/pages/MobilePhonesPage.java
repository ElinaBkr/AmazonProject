package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MobilePhonesPage extends BasePage{
    public MobilePhonesPage (WebDriver driver) {
        super(driver);
    }
    public void navigateToMenu() {
        getDriver().findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public void navigateToElectronics() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement electronicsAndComputers = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[20]/a"));
        js.executeScript("arguments[0].scrollIntoView(true);", electronicsAndComputers);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(electronicsAndComputers));
        electronicsAndComputers.click();
    }
    public void navigateToPhonesAndAccessories() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phonesAndAccessories = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hmenu-content\"]/ul[38]/li[8]/a")));
        phonesAndAccessories.click();
    }
    public void navigateToPhones() {
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[2]/div[1]/div[1]/div/p/a[1]")).click();
    }
}



