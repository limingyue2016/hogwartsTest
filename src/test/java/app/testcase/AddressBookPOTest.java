package app.testcase;

import app.page.AddressBookPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressBookPOTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/department.csv", numLinesToSkip = 1)
    void departmentAddTest(String department) {
        // 添加部门
        AddressBookPage addressBookPage = mainPage.ToAddressBook();
        addressBookPage.departmentAdd(department);
        // 搜索添加结果
        addressBookPage.searchHandle(department);
        // 断言搜索结果
        String content = addressBookPage.getResultText();
        assertTrue(content.contains(department));
    }
}