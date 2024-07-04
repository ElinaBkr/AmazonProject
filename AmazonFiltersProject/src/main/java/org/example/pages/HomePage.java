package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void loadHomePage() {
        driver.get("https://www.amazon.co.uk/");
        //driver.manage().window().maximize();
    }
    public void acceptTermsAndConditions() {
        getDriver().findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
    }
}
