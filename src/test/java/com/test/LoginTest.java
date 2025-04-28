package com.test;

import com.pages.HomePage;
import com.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
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
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.login("edisonzyberaj@gmail.com", "");

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
    }

    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}