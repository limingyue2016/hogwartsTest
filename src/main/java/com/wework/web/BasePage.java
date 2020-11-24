package com.wework.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage() {

    }

    void click(By by) {
        driver.findElement(by).click();
    }

    void click(By by, int index) {
        driver.findElements(by).get(index).click();
    }

    void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

    String getText(By by) {
        return driver.findElement(by).getText();
    }

    void clearText(By by) {
        driver.findElement(by).clear();
    }

    void hover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement((WebElement) by).perform();
    }
}
