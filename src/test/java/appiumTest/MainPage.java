package appiumTest;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class MainPage extends BasePage {
    public AddressBookPage addressBookJump() throws MalformedURLException {
        driver = setDriver();
        clickEle(By.id("com.tencent.wework:id/egd"));
        clickEle(By.xpath("//*[@resource-id=\"com.tencent.wework:id/i6r\"]/android.widget.RelativeLayout[2]"));
        return new AddressBookPage(driver);
    }
}
