package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectSize(String size) {
        driver.findElement(By.xpath("//div[@option-label='" + size + "']")).click();
    }

    public void selectColor(String color) {
        driver.findElement(By.xpath("//div[@option-label='" + color + "']")).click();
    }

    public void clickAddToCart() {
        driver.findElement(By.id("product-addtocart-button")).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(By.cssSelector(".message-success.success.message")).getText();
    }
}