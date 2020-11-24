package com.wework.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {
    public static String url = "https://work.weixin.qq.com/wework_admin/frame";

    public MainPage() throws IOException {
        // mac上需要注释掉
//        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
        driver = new ChromeDriver();
        // 登录企业微信
        this.beforeAll();
    }

    static void beforeAll() throws IOException {
        File file = new File("cookies.yaml");
        if (file.exists()) {
            //利用cookie复用session登录
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {
            };
            // 文件中读取cookies
            List<HashMap<String, Object>> cookies = (List<HashMap<String, Object>>) mapper.readValue(new File("cookies.yaml"), typeReference);
            // 登录信息中添加cookies
            cookies.forEach(cookieMap -> {
                driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
            });

            //刷新页面
            driver.navigate().refresh();
        } else {
            // 首次登录,需要扫码保存cookie
            needLogin();
        }
    }

    private static void needLogin() {
        driver.get(url);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 获取登录的cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File("cookies.yaml"), cookies);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 首页-添加成员为入口
    public ContactPage contact() {
        click(By.linkText("添加成员"));

        return new ContactPage(driver);
    }
}
