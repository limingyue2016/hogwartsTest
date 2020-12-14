package com.service.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WiremockTest {
    @BeforeAll
    static void init() {
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        // If you’ve changed the port number and/or you’re running the server on another host, you’ll need to tell the client
        configureFor("127.0.0.1", 8089);
    }

    @Test
    public void stubMock() throws InterruptedException {
        stubFor(get(urlEqualTo("/test"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("test")));

        Thread.sleep(500000);
    }

    @Test
    public void easyMock() throws InterruptedException {
        stubFor(get(urlEqualTo("/test"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("test")));

        Thread.sleep(10000);

        reset();
        stubFor(get(urlEqualTo("/test"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("test_01")));

        Thread.sleep(500000);
    }

    @Test
    public void proxyMock() throws InterruptedException, URISyntaxException, IOException {
        stubFor(get(urlMatching(".*")).atPriority(10)
                .willReturn(aResponse().proxiedFrom("https://ceshiren.com")));

        stubFor(get(urlEqualTo("/categories_and_latest")).atPriority(10)
                .willReturn(aResponse().withBody(Files.readAllBytes(Paths.get(WiremockTest.class.getResource("/mock.json").toURI())))));

        Thread.sleep(500000);
    }
}

