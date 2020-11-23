package app.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AddressBookPage extends BasePage {
    private By menu = By.id("com.tencent.wework:id/i6i");
    private By departAddLocator = By.xpath("//*[@text='添加子部门']");
    private By addEditText = By.xpath("//*[@text='请输入部门名称']");
    private By confirmButton = By.xpath("//*[@text='确定']");
    private By cancelButton = By.xpath("//*[@text='取消']");
    ;
    private By closeButton = By.id("com.tencent.wework:id/i6d");
    private By searchButton = By.id("com.tencent.wework:id/i6n");
    private By searchEditText = By.xpath("//*[@text='搜索']");
    private By resultText = By.xpath("//android.widget.RelativeLayout//android.view.ViewGroup//android.widget.TextView");

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

    public AddressBookPage searchHandle(String department) {
        clickEle(searchButton);
        sendKeys(searchEditText, department);
        return this;
    }

    public String getResultText() {
        return getText(resultText);
    }
}
