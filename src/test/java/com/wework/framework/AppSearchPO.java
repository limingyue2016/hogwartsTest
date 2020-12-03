package com.wework.framework;

import com.wework.core.App;
import com.wework.core.MainPage;

public class AppSearchPO extends BaseTest {
    private MainPage mainPage;

    public AppSearchPO() {
    }

    public void run() {
        steps.forEach(step -> {
            String key = step.keySet().iterator().next();
            if (step.containsKey("App")) {
                mainPage = new App().start();
            }

            if (key.contains(".")) {
                String[] objectMethod = key.split("\\.");
                String object = objectMethod[0];
                String method = objectMethod[1];

                if (method.equals("search")) {
                    mainPage.toAddressBook();
                }
            }
        });
    }
}
