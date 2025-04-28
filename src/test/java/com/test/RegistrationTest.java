package com.test;

import com.pages.HomePage;
import com.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.UUID;

public class RegistrationTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testUserRegistration() {
        String uniqueEmail = "test" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";

        RegisterPage registerPage = homePage.navigateToRegisterPage();

        registerPage.register("Test", "User", uniqueEmail, "Test@123");

        Assert.assertTrue(driver.getPageSource().contains("Thank you for registering"),
                "Registration confirmation message not displayed");
    }

    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}