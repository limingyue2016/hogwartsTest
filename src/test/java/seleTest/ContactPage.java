package seleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 1 添加部门
 * 2 添加成员
 */
public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    // 添加部门
    public ContactPage departmentAdd(String departName) {
        click(By.linkText("添加"));
        click(By.linkText("添加部门"));
        sendKeys(By.name("name"), departName);
        click(By.linkText("选择所属部门"));
        click(By.linkText("风华正茂有限公司"));
        click(By.linkText("确定"));
        return this;
    }

    // 添加成员
    public ContactPage membersAdd(String username, String acctid, String mobile) {
        return this;
    }

    // 搜索
    public ContactPage searchHandle() {
        return this;
    }

   // 获取搜索结果文本
    public String getResultText(){
        String content = "";
        return content;
    }
}
