package appiumTest.actions;

import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private By addressBook = By.xpath("//*[@text='通讯录']");
    public MainPage(){
        driver = setDriver();
    }

    public AddressBookPage addressBookJump(){
        clickEle(addressBook);
        return new AddressBookPage(driver);
    }
}
