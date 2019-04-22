package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    public static final String SEARCHFIELD = "gh-ac";

    public static void main(String[] args) {
        WebDriver driverFf = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverFf.get("https://www.ebay.com/");
        driver.get("https://www.ebay.com/");

        /* Search "Kodilla" in ebay.com opened in Firefox browser */
        WebElement searchFieldFf = driverFf.findElement(By.id(SEARCHFIELD));
        searchFieldFf.sendKeys("Laptop");
        searchFieldFf.submit();

        /* Search "Kodilla" in ebay.com opened in Chromium browser */
        WebElement searchField = driver.findElement(By.id(SEARCHFIELD));
        searchField.sendKeys("Laptop");
        searchField.submit();
    }
}
