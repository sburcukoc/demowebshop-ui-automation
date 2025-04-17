package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By searchBox = By.id("small-searchterms");

    public void searchForProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName + Keys.ENTER);
    }
}
