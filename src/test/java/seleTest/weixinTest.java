package seleTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 1 selenium环境搭建 done
 * 2 微信登录 done
 */
@SuppressWarnings("unchecked")
public class weixinTest extends BaseCase {
    public String url = "https://work.weixin.qq.com/wework_admin/frame";

    @Test
    @Disabled
    void loginTest() {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void reloginTest() throws IOException {
        driver.get(url);

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
    }
}
