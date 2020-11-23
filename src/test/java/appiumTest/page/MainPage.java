package appiumTest.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private By addressBook = By.xpath("//*[@text='通讯录']");

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    // 跳转到通讯录tab
    public AddressBookPage ToAddressBook() {
        clickEle(addressBook);
        return new AddressBookPage(driver);
    }
}
