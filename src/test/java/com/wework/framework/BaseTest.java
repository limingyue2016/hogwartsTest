package com.wework.framework;

import com.wework.app.AddressBookPage;
import com.wework.core.App;
import com.wework.core.MainPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
    protected static App app;
    public static MainPage mainPage;
    public static AddressBookPage addressBookPage;

    public List<String> data;
    public List<HashMap<String, Object>> steps;
    public int index = 0;

    @BeforeAll
    static void beforeAll() {
        app = new App();
        mainPage = app.start();
        addressBookPage = mainPage.ToAddressBook();
    }

    @AfterEach
    void back() {
        // 因多条数据执行用例，以下处理作为临时teardown方法，用以保证上一条case可以回退到初始操作界面
        pressBack();
        pressBack();
    }

   // 替换yaml中的变量
    public Object getValue(HashMap<String, Object> step, String key) {
        Object value = step.get(key);
        if(value instanceof String){
            // 仅实现了简单结构的替换逻辑，复杂结构需要递归替换
            return ((String) value).replace("${ data }", data.get(index));
        } else {
            return value;
        }
    }

   // 测试用例裂变，基于数据自动生成多份测试用例
    public List<AddressBook> addressBookGenerate() {
        List<AddressBook> addressBookList = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            AddressBook addressBook = new AddressBook();
            addressBook.index = i;
            addressBook.steps = steps;
            addressBook.data = data;

            addressBookList.add(addressBook);
        }
        return addressBookList;
    }

    public void pressBack() {
        mainPage.driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
}
