package com.wework.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookPOTest extends BaseTest {
    @AfterEach
    void afterEach() {
        // 返回首页
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/department.csv", numLinesToSkip = 1)
    void departmentAdd(String department) {
        // 添加部门
        addressBookPage.departmentAdd(department);
        // 搜索添加结果
        addressBookPage.searchHandle(department);
        // 断言搜索结果
        String content = addressBookPage.getResultText();
        assertTrue(content.contains(department));
    }

    @ParameterizedTest
    @CsvSource({
            "运营部门1"
    })
    void departmentDelete(String department) {
        // 删除部门
        addressBookPage.deleteEmptyDepart(department);
        // 搜索删除结果
        addressBookPage.searchHandle(department);
        // 断言删除结果
        String content = addressBookPage.getResultTextEmpty();
        if (content.equals("")) {
            assertEquals("", content);
        } else {
            assertEquals("无搜索结果", content);
        }
    }

    @Test
    void test() {
        addressBookPage.back("input keyevent 4");
        assertNull("");
    }
}