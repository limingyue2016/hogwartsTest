package com.wework.core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class App {
    public static AndroidDriver driver;

    public MainPage start() {
        driver = setDriver();
        new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='通讯录']")));
        return new MainPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    //初始化apk配置
    public DesiredCapabilities setCa() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "3304cae3");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("appPackage", "com.tencent.wework");
        capabilities.setCapability("appActivity", ".launch.WwMainActivity");
        capabilities.setCapability("noReset", true);
        return capabilities;
    }

    //初始化driver
    public AndroidDriver setDriver() {
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), this.setCa());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}
