package com.wework.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressBookPOTest extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/department.csv", numLinesToSkip = 1)
    void addDepartment(String department) {
        // 添加部门
        addressBookPage.departmentAdd(department);
        // 搜索添加结果
        addressBookPage.searchHandle(department);
        // 断言搜索结果
        String content = addressBookPage.getResultText();
        assertTrue(content.contains(department));

        backAddressBookPage();
    }

    @ParameterizedTest
    @CsvSource({
            "运营部门1",
            "运行部门1"
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

    @ParameterizedTest
    @CsvSource({
            "运营部门, 运营部门1"
    })
    void editDepart(String department, String replacement) {
        // 修改部门
        addressBookPage.editDepart(department, replacement);
        // 搜索修改结果
        addressBookPage.searchHandle(replacement);
        // 断言修改结果
        String content = addressBookPage.getResultText();
        assertTrue(content.contains(replacement));

        backAddressBookPage();
    }

    public void backAddressBookPage() {
        addressBookPage.back();
        addressBookPage.back();
    }
}