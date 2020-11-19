package appiumTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContactPOTest extends BasePage {

    public ContactPOTest() throws MalformedURLException {
    }

    @Test
    void searchTest() {
        driver.findElement(By.id("com.tencent.wework:id/i6n")).click();
        driver.findElement(By.id("com.tencent.wework:id/gpg")).sendKeys("limingyue");

        assertNotNull(driver.findElement(By.xpath("//*[@text=\"联系人\"]")));
    }
}
