package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("pass")).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(By.id("send2")).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignInButton();
    }

    public boolean isLoginSuccessful() {
        try {
            return driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}