package appiumTest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AddressBookPage extends BasePage{
    public AddressBookPage(AndroidDriver driver) {
    }

    public AddressBookPage departmentAdd(String departName){
        clickEle(By.id("com.tencent.wework:id/ex9"));
        return this;
    }
}
