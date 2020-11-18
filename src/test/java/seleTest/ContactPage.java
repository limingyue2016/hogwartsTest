package seleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 1 添加部门
 * 2 添加成员
 */
public class ContactPage extends BasePage {
    WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage() {

    }

    // 添加部门
    public ContactPage departmentAdd(String departName) {
//        wait = new WebDriverWait(driver, 5);
        click(By.linkText("添加"));
        click(By.linkText("添加部门"));
        sendKeys(By.name("name"), departName);
        click(By.linkText("选择所属部门"));
//        wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) By.linkText("风华正茂有限公司")));
//        wait.until(ExpectedConditions.presenceOfElementLocated((By.ByLinkText, "风华正茂有限公司")));
        click(By.linkText("风华正茂有限公司"), 1);
        click(By.linkText("确定"));
        return this;
    }
    // 修改部门
    ContactPage departmentModify(String departName, String replacement){
        // 清理搜索框内容
        clearText(By.cssSelector("input[placeholder='搜索成员、部门']"));
        // 搜索待修改部门名称
        searchHandle(departName);
        // 修改部门名称
        click(By.linkText("修改名称"));
        clearText(By.cssSelector("input[value=" + departName + "]"));
        click(By.cssSelector("input[value=" + departName + "]"));
        sendKeys(By.cssSelector("input[value=" + departName + "]"), replacement);
        click(By.linkText("保存"));
        // 刷新页面
        driver.navigate().refresh();
        return this;
    }

    // 删除部门
    ContactPage departmentDelete(String departName) throws InterruptedException {
        Thread.sleep(1000);
        click(By.linkText(departName));
        click(By.xpath("//a[contains(text()," + departName+ ")]/span"));
        Thread.sleep(1000);
        click(By.xpath("删除"));
        click(By.linkText("确定"));
        return this;
    }

    // 添加成员
    public ContactPage membersAdd(String username, String acctid, String mobile) {
        return this;
    }

    // 搜索
    public ContactPage searchHandle(String searchText) {
        click(By.id("memberSearchInput"));
        sendKeys(By.cssSelector("input[placeholder='搜索成员、部门']"), searchText);
        return this;
    }

   // 获取搜索结果文本
    public String getResultText(){
        String content = getText(By.id("party_name"));
        return content;
    }
}
