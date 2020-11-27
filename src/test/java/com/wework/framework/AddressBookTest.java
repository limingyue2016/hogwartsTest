package com.wework.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.wework.app.AddressBook;
import com.wework.common.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.Stream;

public class AddressBookTest extends BaseTest {
    @ParameterizedTest
    @MethodSource()
    void searchDepartment(AddressBook search) {
        search.run();
    }

    static Stream<AddressBook> searchDepartment() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        AddressBook search = mapper.readValue(AddressBookTest.class.getResourceAsStream("/framework/searchDeparts.yaml"), AddressBook.class);
        AddressBook search = mapper.readValue(new FileInputStream("src/test/resources/framework/searchDeparts.yaml"), AddressBook.class);
        return Stream.of(search);
    }
}
