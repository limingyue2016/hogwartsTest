package com.wework.framework;

import com.wework.core.BasePage;
import org.openqa.selenium.By;

public class AddressBookPage extends BasePage {
    public void searchHandle(String department) {
        clickEle(By.id("i6n"));
        sendKeys(By.xpath("//*[@text='搜索']"), department);
    }
}
