package com.service.restassured;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class Demo {
    private static String corpid = "wwc0d2037957675e5c";
    private static String corpsecret = "-mdNgIh6Z0dnWqT-qVqkgqOLnJfyx9dfZOSeJdI8RwQ";
    public static String access_token;


    @BeforeAll
    static void getToken() {
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";

        access_token =
                given()
                        .param("corpid", corpid)
                        .param("corpsecret", corpsecret)
                        .when()
                        .get(url)
                        .then()
                        .extract().response().path("access_token");
    }

    @Test
    public void postTest() {
        given()
                .body("{\n" +
                        "   \"touser\" : \"LiMingYue\",\n" +
                        "   \"msgtype\" : \"text\",\n" +
                        "   \"agentid\" : 1000002,\n" +
                        "   \"text\" : {\n" +
                        "       \"content\" : \"你的快递已到，请携带工卡前往邮件中心领取。\\n出发前可查看<a href=\\\"http://work.weixin.qq.com\\\">邮件中心视频实况</a>，聪明避开排队。\"\n" +
                        "   },\n" +
                        "}")
                .post("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + access_token)
                .then()
                .log().all();
    }

    @Test
    public void demoTest() {
        String url = "http://127.0.0.1:8080";

        given()
                .get("/index.json")
                .then()
                .body("lotto.winners.winnerId", hasItems(23, 54));
    }
}
