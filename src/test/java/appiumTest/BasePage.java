package appiumTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BasePage {
    public AndroidDriver driver;
    public static final String BaseId = "com.tencent.wework:id/";

    //初始化apk配置
    public DesiredCapabilities setCa() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "zlizk7bi7pjfyhvc");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("appPackage", "com.tencent.wework");
        capabilities.setCapability("appActivity", ".launch.WwMainActivity");
        capabilities.setCapability("noReset", true);
        return capabilities;
    }

    //初始化driver
    public AndroidDriver setDriver() throws MalformedURLException {
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), this.setCa());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    // 封装智能等待方法
    private Boolean waitToDisplayed(final By loc) {
        Boolean waitDisplayed = false;
        waitDisplayed = new WebDriverWait(this.driver, 10).until((ExpectedCondition<Boolean>) d -> d.findElement(loc).isDisplayed());
        return waitDisplayed;
    }

    // 定位单个元素方法
    protected WebElement findEle(By loc) {
        WebElement ele = null;
        if (this.waitToDisplayed(loc)) {
            ele = this.driver.findElement(loc);
        }
        return ele;
    }

    // 定位一组元素方法
    public List<WebElement> findEles(By loc) {
        List<WebElement> eles = null;
        if (this.waitToDisplayed(loc)) {
            eles = this.driver.findElements(loc);
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
    // 打Log方法


}
