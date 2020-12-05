package com.wework.core;

import com.wework.app.AddressBookPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private By addressBook = By.xpath("//*[@text='通讯录']");

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    // 跳转到通讯录tab
    public AddressBookPage toAddressBook() {
        // 可以写java代码，也可以读取mainPO.yaml
        clickEle(addressBook);
        return new AddressBookPage(driver);
    }
}
