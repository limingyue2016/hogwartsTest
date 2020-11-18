package seleTest;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1 批量添加部门
 * 2 修改部门
 * 3 删除部门
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactPOTest extends MainPage {

    private static MainPage mainPage;
    private ContactPage contactPage;

    public ContactPOTest() throws IOException {
    }

    @BeforeAll
    static void beforeAll() throws IOException {
        mainPage = new MainPage();
    }

    // 添加部门功能测试
    @Order(1)
    @ParameterizedTest
    @CsvFileSource(resources = "/department.csv", numLinesToSkip = 1)
    void departmentAddTest(String department){
        // 跳转页面
        contactPage = mainPage.contact();
        // 添加部门
        contactPage.departmentAdd(department);
        // 搜索添加结果
        contactPage.searchHandle(department);
        // 断言搜索结果
        String content = contactPage.getResultText();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(content.contains(department));
    }

    // 修改部门功能测试
    @Order(2)
    @ParameterizedTest
    @CsvSource({
            "测试部门,         测试部门1"
    })
    void departmentModifyTest(String department, String replacement){
        contactPage = mainPage.contact();
        // 修改部门
        contactPage.departmentModify(department, replacement);
        // 搜索添加结果
        contactPage.searchHandle(replacement);
        // 断言修改结果
        String content = contactPage.getResultText();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(content.contains(department));
    }
    @Order(3)
    @ParameterizedTest
    @CsvSource({
            "测试部门"
    })
    @Disabled
    void departmentDeleteTest(String department) throws InterruptedException {
        contactPage = mainPage.contact();
        // 删除部门
        contactPage.departmentDelete(department);
        // 搜索删除结果
        contactPage.searchHandle(department);
        // 断言删除结果
        String content = contactPage.getResultText();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotEquals(content, department);
    }
}
