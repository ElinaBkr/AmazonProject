package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.SamsungPhonesPage;
import org.example.pages.HomePage;
import org.example.pages.MobilePhonesPage;
import org.example.pages.MobilePhonesPage;
import org.example.pages.SamsungPhonesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import java.util.List;


public class SamsungPhonesStepDefinitions {
    private WebDriver driver;
    private HomePage homePage;
    private MobilePhonesPage mobilePhonesPage;
    private SamsungPhonesPage samsungPhonesPage;

    @Given("I am on the Amazon home page and accept the T&C")
    public void i_am_on_the_amazon_home_page_and_accept_the_t_c() {

        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.loadHomePage();
        homePage.acceptTermsAndConditions();
    }

    @When("I navigate to {string} > {string} > {string}")
    public void i_navigate_to(String category, String subCategory, String productType) {
        mobilePhonesPage = new MobilePhonesPage (driver);
        mobilePhonesPage.navigateToMenu();
        mobilePhonesPage.navigateToElectronics();
        mobilePhonesPage.navigateToPhonesAndAccessories();
        mobilePhonesPage.navigateToPhones();
    }

    @And("I filter by Camera Resolution {string}, Model Year {string}, Price Range {string}")
    public void i_filter_by_camera_resolution_model_year_price_range(String cameraResolution, String modelYear, String priceRange) {

        samsungPhonesPage = new SamsungPhonesPage(driver);
        samsungPhonesPage.applyModelYearFilter();
        samsungPhonesPage.applyCameraFilter();
        samsungPhonesPage.applyPriceFilter();
        samsungPhonesPage.applyBrandFilter();
    }

    @Then("I should see a list of Samsung phones that match the criteria")
    public void i_should_see_a_list_of_samsung_phones_that_match_the_criteria() {

        List<WebElement> productNames = driver.findElements(By.cssSelector("span.a-size-base-plus.a-color-base.a-text-normal"));
        for (WebElement productName : productNames) {
            String productText = productName.getText();
            Assert.assertTrue("Product name does not contain 'Samsung': " + productText, productText.toLowerCase().contains("samsung"));
        }

        List<WebElement> priceElements = driver.findElements(By.className(".a-price-whole"));
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace(",", "").trim();
            double price = Double.parseDouble(priceText);
            Assert.assertTrue("Price " + price + " is not within the range 50-100", price >= 50 && price <= 100);

            driver.quit();
        }
    }
}
