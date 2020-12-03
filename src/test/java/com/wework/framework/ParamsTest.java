package com.wework.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

public class ParamsTest extends BaseTest {
    @ParameterizedTest
    @MethodSource()
    void searchDepartment(AppSearch search) {
        search.run();
    }

    static List<AppSearch> searchDepartment() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        AppSearch search = mapper.readValue(ParamsTest.class.getResourceAsStream("/framework/searchDeparts.yaml"), AppSearch.class);
//        AddressBook search = mapper.readValue(new FileInputStream("src/test/resources/framework/searchDeparts.yaml"), AddressBook.class);
        return search.testcaseGenerate();
    }
}
