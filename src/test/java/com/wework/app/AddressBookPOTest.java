package com.wework.app;

import com.wework.common.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AddressBookPOTest extends BaseTest {
    @AfterEach
    void afterEach() {
        backAddressBookPage();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/department.csv", numLinesToSkip = 1)
    void addDepartment(String department) {
        // 添加部门
        addressBookPage.addDepart(department);
        // 搜索添加结果
        addressBookPage.searchHandle(department);
        // 断言搜索结果
        String content = addressBookPage.getResultText();
        assertTrue(content.contains(department));
    }

    @ParameterizedTest
    @CsvSource({
            "运营部门, 运营部门1"
    })
    void editDepartment(String department, String replacement) {
        // 修改部门
        addressBookPage.editDepart(department, replacement);
        // 搜索修改结果
        addressBookPage.searchHandle(replacement);
        // 断言修改结果
        String content = addressBookPage.getResultText();
        assertTrue(content.contains(replacement));
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    void deleteDepartment(String department) {
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

    static Stream<Arguments> listProvider() {
        return Stream.of(
                arguments("运营部门"),
                arguments("产品部门")
        );
    }

    public void backAddressBookPage() {
        addressBookPage.back();
        addressBookPage.back();
    }
}