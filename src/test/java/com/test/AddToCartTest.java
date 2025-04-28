package com.test;

import com.pages.HomePage;
import com.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testAddProductToCart() {

        homePage.searchProduct("yoga pant");

        homePage.selectFirstProductFromResults();

        ProductPage productPage = new ProductPage(driver);

        productPage.selectSize("M");
        productPage.selectColor("Black");
        productPage.clickAddToCart();

        String successMessage = productPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("You added"),
                "Add to cart confirmation message not displayed");
    }

    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}