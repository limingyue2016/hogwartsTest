package seleTest;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * todo
 */
public class ContactPOTest extends MainPage {

    public ContactPOTest() throws IOException {
    }

    @Test
    void departmentAddTest() throws IOException {
        // todo 测试添加部门是否成功
        MainPage mainPage = new MainPage();
        // 主页面进入添加成员入口
        mainPage.contact();
        // 搜索添加结果
        ContactPage contactPage = new ContactPage();
        contactPage.searchHandle();
        // 断言结果
        assertTrue(true);
    }
}
