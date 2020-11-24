package com.wework.app;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AddressBookPage extends BasePage {
    private final By menu = By.id("i6i");
    private final By departAddLocator = By.xpath("//*[@text='添加子部门']");
    private final By departDeleteLocator = By.xpath("//*[@text='删除部门']");
    private final By addEditText = By.xpath("//*[@text='请输入部门名称']");
    private final By confirmButton = By.xpath("//*[@text='确定']");
    private final By cancelButton = By.xpath("//*[@text='取消']");
    private final By closeButton = By.id("i6d");
    private final By searchButton = By.id("i6n");
    private final By searchEditText = By.xpath("//*[@text='搜索']");
    private final By resultText = By.xpath("//android.widget.RelativeLayout//android.view.ViewGroup//android.widget.TextView");
    private final By backMenu = By.id("i63");
    private final By moreManagement = By.xpath("//*[@text='更多管理']");
//    private By closeButton=By.xpath("//*[contains(@resource-id, 'gpf') or contains(@resource-id, 'i6d')]");

    public AddressBookPage(AndroidDriver driver) {
        super(driver);
    }

    public AddressBookPage departmentAdd(String departName) {
        clickEle(menu);
        clickEle(departAddLocator);
        sendKeys(addEditText, departName);
        clickEle(confirmButton);
        clickEle(closeButton);
        return this;
    }

    public void searchHandle(String department) {
        clickEle(searchButton);
        sendKeys(searchEditText, department);
    }

    public String getResultText() {
        return getText(resultText);
    }

    public void clearEmptyDepart(String department) {
        clickEle(backMenu);
        clickEle(menu);
        clickEle(By.xpath("//*[@text=" + department + "]"));
        clickEle(moreManagement);
        clickEle(departDeleteLocator);
        clickEle(confirmButton);
    }
}
