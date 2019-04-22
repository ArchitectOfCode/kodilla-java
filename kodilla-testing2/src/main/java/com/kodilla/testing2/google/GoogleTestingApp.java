package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "q";

    public static void main(String[] ars) {
        WebDriver driverFf = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverFf.get("https://www.google.com");
        driver.get("https://www.google.com");

        /* Search "Kodilla" in Google.com opened in Firefox browser */
        WebElement searchFieldFf = driverFf.findElement(By.name(SEARCHFIELD));
        searchFieldFf.sendKeys("Kodilla");
        searchFieldFf.submit();

        /* Search "Kodilla" in Google.com opened in Chromium browser */
        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}
