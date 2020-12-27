package com.motaharinia.grpcserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//https://github.com/yidongnan/grpc-spring-boot-starter/blob/master/README.md
//https://github.com/yidongnan/grpc-spring-boot-starter/tree/master/examples
//https://github.com/yidongnan/grpc-spring-boot-starter/tree/master/examples/local-grpc-server/src/main/java/net/devh/boot/grpc/examples/local/server
//https://github.com/yidongnan/grpc-spring-boot-starter/tree/master/examples/local-grpc-client/src/main/java/net/devh/boot/grpc/examples/local/client


@SpringBootApplication(scanBasePackages = {"com.motaharinia"})
@EnableEurekaClient
//@EnableZuulProxy
public class GrpcStarterServerEurekaApplication {

    public static void main(String[] args) throws Exception  {
        SpringApplication.run(GrpcStarterServerEurekaApplication.class, args);
    }

}
