package com.wework.app;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AddressBookPage extends BasePage {
    private final By menu = By.id("i6i");
    private final By departAddLocator = By.xpath("//*[@text='添加子部门']");
    private final By departDeleteLocator = By.xpath("//*[@text='删除部门']");
    private final By departEditLocator = By.xpath("//*[@text='修改当前部门名称']");
    private final By addEditText = By.id("blm");
    private final By confirmButton = By.xpath("//*[@text='确定']");
    private final By cancelButton = By.xpath("//*[@text='取消']");
    private final By closeButton = By.id("i6d");
    private final By searchButton = By.id("i6n");
    private final By searchEditText = By.xpath("//*[@text='搜索']");
    private final By resultText = By.xpath("//android.widget.RelativeLayout//android.view.ViewGroup//android.widget.TextView");
    private final By resultTextEmpty = By.xpath("//android.widget.FrameLayout//android.widget.ListView");
    private final By moreManagement = By.xpath("//*[@text='更多管理']");

    public AddressBookPage(AndroidDriver driver) {
        super(driver);
    }

    public AddressBookPage addDepart(String departName) {
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

    public String getResultTextEmpty() {
        return getText(resultTextEmpty);
    }

    public void editDepart(String department, String replacement) {
        clickEle(menu);
        clickEle(By.xpath("//*[@text='" + department + "']"));
        clickEle(moreManagement);
        clickEle(departEditLocator);
        sendKeys(addEditText, replacement);
        clickEle(confirmButton);
        clickEle(closeButton);
    }

    public void deleteEmptyDepart(String department) {
        clickEle(menu);
        clickEle(By.xpath("//*[@text='" + department + "']"));
        clickEle(moreManagement);
        clickEle(departDeleteLocator);
        clickEle(confirmButton);
        clickEle(closeButton);
    }

    public void back() {
        pressBack();
    }

    public void testCommand() {
        executeScriptCommand();
    }
}
