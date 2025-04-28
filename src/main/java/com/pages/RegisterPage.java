package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(By.id("firstname")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.id("lastname")).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email_address")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        driver.findElement(By.id("password-confirmation")).sendKeys(password);
    }

    public void clickCreateAccountButton() {
        driver.findElement(By.cssSelector("button[title='Create an Account']")).click();
    }

    public void register(String firstName, String lastName, String email, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(password);
        clickCreateAccountButton();
    }
}
