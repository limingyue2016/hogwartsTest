package com.wework.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

public class ParamsPOTest extends BaseTest{
    @ParameterizedTest
    @MethodSource()
    void searchDepartment(AppSearchPO search) {
        search.run();
    }

    static List<AppSearchPO> searchDepartment() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        AppSearchPO search = mapper.readValue(ParamsPOTest.class.getResourceAsStream("/framework/searchPOTest.yaml"), AppSearchPO.class);
        return search.testcaseGeneratePO();
    }
}
