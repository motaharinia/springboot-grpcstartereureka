package com.motaharinia.discoveryserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//https://zoltanaltfatter.com/2018/05/15/spring-cloud-discovery-with-spring-boot-admin/

@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer
public class DiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }

}
