package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
        searchBox.clear();
        searchBox.sendKeys(productName);
        driver.findElement(By.cssSelector("button.action.search")).click();
    }

    public ProductPage selectFirstProductFromResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li.product-item a.product-item-link")));
        firstProduct.click();
        return new ProductPage(driver);
    }

    public LoginPage navigateToLoginPage() {
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        return new LoginPage(driver);
    }

    public RegisterPage navigateToRegisterPage() {
        WebElement createAccountLink = driver.findElement(By.linkText("Create an Account"));
        createAccountLink.click();
        return new RegisterPage(driver);
    }
}