package appiumTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * 页面基类
 */
public class BasePage {
    public AndroidDriver driver;

    public BasePage() throws MalformedURLException {
        this.beforeAll();
    }

    void beforeAll() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
//        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "com.tencent.wework");
//        capabilities.setCapability("appActivity", ".launch.WwMainActivity");
//        capabilities.setCapability(MobileCapabilityType.UDID, "zlizk7bi7pjfyhvc");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "zlizk7bi7pjfyhvc");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        capabilities.setCapability("deviceName", "zlizk7bi7pjfyhvc");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("appPackage", "com.tencent.wework");
        capabilities.setCapability("appActivity", ".launch.WwMainActivity");
        capabilities.setCapability("noReset", true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
