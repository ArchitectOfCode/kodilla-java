package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_MONTH = "//div[@class=\"_5k_5\"]/span/span/select[@aria-label=\"Month\"]";
    public static final String XPATH_DAY = "//div[@class=\"_5k_5\"]/span/span/select[@aria-label=\"Day\"]";
    public static final String XPATH_YEAR = "//div[@class=\"_5k_5\"]/span/span/select[@aria-label=\"Year\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement monthCombo = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(monthCombo);
        selectMonth.selectByIndex(3);

        WebElement dayCombo = driver.findElement(By.xpath(XPATH_DAY));
        dayCombo.sendKeys("15");

        WebElement yearCombo = driver.findElement(By.xpath(XPATH_YEAR));
        yearCombo.sendKeys("1945");
    }
}
