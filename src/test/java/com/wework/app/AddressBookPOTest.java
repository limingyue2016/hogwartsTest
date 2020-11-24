package com.wework.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressBookPOTest extends BaseTest {
    public AddressBookPage addressBookPage;

    @ParameterizedTest
    @CsvFileSource(resources = "/department.csv", numLinesToSkip = 1)
    void departmentAddTest(String department) {
        addressBookPage = mainPage.ToAddressBook();
        // 添加部门
        addressBookPage.departmentAdd(department);
        // 搜索添加结果
        addressBookPage.searchHandle(department);
        // 断言搜索结果
        String content = addressBookPage.getResultText();
        assertTrue(content.contains(department));
        // 删除添加的部门
        addressBookPage.clearEmptyDepart(department);
    }
}