package com.wework.web;

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

    public ContactPage addDepart(String departName) {
        click(By.linkText("添加"));
        click(By.linkText("添加部门"));
        sendKeys(By.name("name"), departName);
        click(By.linkText("选择所属部门"));
        click(By.linkText("风华正茂有限公司"), 1);
        click(By.linkText("确定"));
        return this;
    }

    public ContactPage editDepart(String departName, String replacement) {
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

    public ContactPage deleteDepart(String departName) throws InterruptedException {
        Thread.sleep(1000);
        click(By.linkText(departName));
        click(By.xpath("//a[contains(text()," + departName + ")]/span"));
        Thread.sleep(1000);
        click(By.xpath("删除"));
        click(By.linkText("确定"));
        return this;
    }

    public ContactPage membersAdd(String username, String acctid, String mobile) {
        return this;
    }

    public ContactPage searchHandle(String searchText) {
        click(By.id("memberSearchInput"));
        sendKeys(By.cssSelector("input[placeholder='搜索成员、部门']"), searchText);
        return this;
    }

    public String getResultText() {
        String content = getText(By.id("party_name"));
        return content;
    }
}
