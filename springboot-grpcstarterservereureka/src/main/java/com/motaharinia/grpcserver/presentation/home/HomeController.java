package com.motaharinia.grpcserver.presentation.home;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-12-20 <br>
 * Time: 00:59:57 <br>
 * Description: <br>
 */
@RefreshScope
@RestController
public class HomeController {

    @Value("${message:Hello default}")
    private String message;

    @GetMapping("/message")
    String getMessage() {
        return this.message;
    }

    @GetMapping("/")
    String home() {
        return "GrpcStarterServerEurekaApplication!";
    }
}
