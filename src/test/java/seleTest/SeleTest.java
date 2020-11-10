package seleTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * 1 selenium环境搭建 done
 */
public class SeleTest {
    public static WebDriver driver;

    @BeforeAll
    static void setup() {
        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    void loginTest() {
        driver.get("https://work.weixin.qq.com/");
        driver.findElement(By.linkText("企业登录")).click();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
