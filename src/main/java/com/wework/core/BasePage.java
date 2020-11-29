package com.wework.core;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BasePage {
    public AndroidDriver driver;
    public WebDriverWait wait;
    private final String[] blackList = {"允许", "同意", "始终允许", "我知道了", "取消", "关闭", "继续"};

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public BasePage() {

    }

    // 封装智能等待方法
    private Boolean waitToDisplayed(By loc) {
        return getWait().until((ExpectedCondition<Boolean>) d -> d.findElement(loc).isDisplayed());
    }

    public WebDriverWait getWait() {
        wait = new WebDriverWait(this.driver, 3);
        return wait;
    }

    public WebDriverWait getWait(long time) {
        wait = new WebDriverWait(this.driver, time);
        return wait;
    }

    // 异常处理
    public void handleException() {
        for (String loc : blackList) {
            List<WebElement> eles = driver.findElements(By.xpath("//*[@text='" + loc + "']"));
            if (eles.size() >= 1) {
                eles.get(0).click();
            }
        }
    }

    // 注册监听并开启监听
    public void runWatcher() {

    }

    // 停止监听
    public void stopWatcher() {
    }

    // 定位单个元素方法
    protected WebElement findEle(By loc) {
        WebElement ele = null;
        if (this.waitToDisplayed(loc)) {
            ele = this.driver.findElement(loc);
        } else {
            handleException();
            findEle(loc);
        }
        return ele;
    }

    // 定位一组元素方法
    public List<WebElement> findEles(By loc) {
        List<WebElement> eles = null;
        if (this.waitToDisplayed(loc)) {
            eles = this.driver.findElements(loc);
        } else {
            handleException();
            findEles(loc);
        }
        return eles;
    }

    // 点击一个元素
    public void clickEle(By loc) {
        WebElement ele = this.findEle(loc);
        ele.click();
    }

    // 点击一组元素中的任一个方法
    public void clickEles(By loc, int i) {
        List<WebElement> eles = this.findEles(loc);
        eles.get(i).click();
    }

    // 输入方法
    public void sendKeys(By loc, String value) {
        try {
            this.findEle(loc).clear();
            this.findEle(loc).click();
            this.findEle(loc).sendKeys(value);
        } catch (NoSuchElementException e) {
            System.out.println("元素" + loc.toString() + "找不到");
        }
    }

    // 获取单个元素文本内容
    public String getText(By loc) {
        return this.findEle(loc).getText();
    }

    // 获取当前日期
    public static String getCurrentDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());
    }

    // 获取脚本名字
    public String getName(String name) {
        String date = getCurrentDateTime();
        String fp = "./src/test/java/result/" + date + "/image/";
        String type = ".png";
        String filename = fp + "\\" + name + type;
        File file = new File(fp);
        if (!file.exists()) {
            file.mkdir();
        } else {
            file = new File("./src/test/java/result/" + filename);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        return filename;
    }

    // 截图方法
    public void captureScreen(String name) throws IOException {
        File screenShotFile = this.driver.getScreenshotAs(OutputType.FILE);
        String filename = this.getName(name);
        FileUtil.copyFile(screenShotFile, new File(filename));
    }

    // 执行adb命令
    public String executeShellCommand(String cmd) {
        String result = String.valueOf(driver.execute(cmd));
        return result;
    }

    public void executeScriptCommand() {
        // todo
        driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
    }


    public void unlock() {
        driver.unlockDevice();
        pressHome();
    }

    public void pressHome() {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
    }

    public void pressBack() {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
}
