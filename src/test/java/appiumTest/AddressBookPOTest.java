package appiumTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddressBookPOTest extends MainPage {
    public MainPage mainPage;

    @Test
    @Disabled
    void searchTest() {
        driver.findElement(By.id("com.tencent.wework:id/i6n")).click();
        driver.findElement(By.id("com.tencent.wework:id/gpg")).sendKeys("limingyue");

        assertNotNull(driver.findElement(By.xpath("//*[@text=\"联系人\"]")));
    }

    @Test
    void test() throws MalformedURLException {
        mainPage = new MainPage();
        mainPage.addressBookJump();

        assertNotNull(mainPage.addressBookJump());
    }
}
