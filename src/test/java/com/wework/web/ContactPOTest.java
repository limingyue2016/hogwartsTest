package com.wework.web;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1 批量添加部门
 * 2 修改部门
 * 3 删除部门
 */
public class ContactPOTest extends BaseTest {
    // 添加部门功能测试
    @ParameterizedTest
    @CsvFileSource(resources = "/department.csv", numLinesToSkip = 1)
    void addDepartment(String department) {
        // 添加部门
        contactPage.addDepart(department);
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
    @ParameterizedTest
    @CsvSource({
            "测试部门,         测试部门1"
    })
    void editDepartment(String department, String replacement) {
        // 修改部门
        contactPage.editDepart(department, replacement);
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

    @ParameterizedTest
    @CsvSource({
            "测试部门"
    })
    @Disabled
    void deleteDepartment(String department) throws InterruptedException {
        // 删除部门
        contactPage.deleteDepart(department);
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
