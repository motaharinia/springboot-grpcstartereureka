package com.motaharinia.gatewayserver;

import com.netflix.zuul.context.RequestContext;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GatewayServerApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    static ConfigurableApplicationContext grpcStarterServerContext;

    @BeforeAll
    public static void startBookService() {
        grpcStarterServerContext = SpringApplication.run(GrpcStarterServer.class, "--server.port=8081");
    }

    @AfterAll
    public static void closeBookService() {
        grpcStarterServerContext.close();
    }

    @BeforeEach
    public void setup() {
        RequestContext.testSetCurrentContext(new RequestContext());
    }

    @Test
    @Order(1)
    public void test() {
        String uri = "http://localhost:" + port + "/server/message";
        String resp = restTemplate.getForObject(uri, String.class);
        assertThat(resp).isEqualTo("GrpcStarterServer");
    }

    @Configuration
    @EnableAutoConfiguration
    @RestController
    static class GrpcStarterServer {
        @RequestMapping("/message")
        public String getMessage() {
            return "GrpcStarterServer";
        }
    }
}
