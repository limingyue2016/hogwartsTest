package com.wework.app;

import com.wework.core.App;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddressBook {
    public AndroidDriver driver;
    public List<String> data;
    public List<HashMap<String, Object>> steps;
    public WebElement currentElement;

    public AddressBook(AndroidDriver driver) {
        // todo 待用
        this.driver = driver;
    }

    public AddressBook() {
    }

    public void run() {
        steps.forEach(step -> {
            if (step.containsKey("find")) {
                ArrayList<By> bys = new ArrayList<>();
                HashMap<String, String> find = (HashMap<String, String>) step.get("find");
                find.forEach((key, value) -> {
                    if (key.contains("id")) {
                        bys.add(By.id(value));
                    }

                    if (key.contains("xpath")) {
                        bys.add(By.xpath(value));
                    }
                });
                currentElement = App.driver.findElement(bys.get(0));
            }

            if (step.containsKey("click")) {
                currentElement.click();
            }

            if (step.containsKey("send_keys")) {
                currentElement.sendKeys("产品部门");
            }
        });
    }
}
