package com.wework.web;

import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public class BaseTest {
    public static MainPage mainPage;
    public static ContactPage contactPage;

    @BeforeAll
    static void beforeAll() throws IOException {
        mainPage = new MainPage();
        contactPage = mainPage.toContact();
    }
}
