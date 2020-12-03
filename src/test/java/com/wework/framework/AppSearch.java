package com.wework.framework;

import com.wework.core.App;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class AppSearch extends BaseTest {
    public WebElement currentElement;

    public AppSearch() {
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
                currentElement.sendKeys(getValue(step, "send_keys").toString());
            }
        });
    }
}
