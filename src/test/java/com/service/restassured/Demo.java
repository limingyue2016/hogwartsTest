package com.service.restassured;

import org.junit.jupiter.api.Test;

public class Demo {
    String corpid = "wwc0d2037957675e5c";
    String corpsecret = "-mdNgIh6Z0dnWqT-qVqkgqOLnJfyx9dfZOSeJdI8RwQ";
    String access_token = "";


    @Test
    public void getTest(){
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
        access_token = given()
                .get(url)
        .then()
        .log()
        .all();
        System.out.println(access_token);
    }

    @Test
    public void postTest(){
        given().post(url);
    }
}
