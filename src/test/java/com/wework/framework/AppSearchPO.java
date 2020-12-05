package com.wework.framework;

import com.wework.core.BasePage;
import com.wework.core.MainPage;

import java.util.ArrayList;

public class AppSearchPO extends BaseTest {
    private MainPage mainPage;

    public AppSearchPO() {
    }

    // 基础思路编写 run引擎
//    public void run() {
//        steps.forEach(step -> {
//            String key = step.keySet().iterator().next();
//            if (step.containsKey("App")) {
//                mainPage = new App().start();
//            }
//
//            if (key.contains(".")) {
//                String[] objectMethod = key.split("\\.");
//                String object = objectMethod[0];
//                String method = objectMethod[1];
//
//                if (method.equals("search")) {
//                    mainPage.toAddressBook();
//                }
//            }
//        });
//    }
    // 基于反射机制 编写run引擎
    public void run() {
        steps.forEach(step -> {
            String key = step.keySet().iterator().next();
            if (step.containsKey("app")) {
                BasePage.getInstance().poInit("app", "");
            }

            if (step.containsKey("init")) {
                ArrayList<String> value = (ArrayList) getValue(step, "init");
                BasePage.getInstance().poInit(value.get(0), value.get(1));
            }

            if (key.contains(".")) {
                String[] objectMethod = key.split("\\.");
                String object = objectMethod[0];
                String method = objectMethod[1];
                // 解决了找方法的问题
                BasePage.getInstance().getPO(object).stepRun(method);
            }
        });
    }
}
