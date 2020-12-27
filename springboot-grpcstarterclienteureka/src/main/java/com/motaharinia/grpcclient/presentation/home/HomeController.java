package com.motaharinia.grpcclient.presentation.home;

import com.motaharinia.grpcclient.business.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GrpcClientService grpcClientService;


    @Value("${message:Hello default}")
    private String message;

    @GetMapping("/message")
    String getMessage() {
        return this.message;
    }

    @GetMapping("/")
    String home() {
        return "GrpcStarterClientEurekaApplication! response from grpc server:" + grpcClientService.sendMessage("eng.motahari@gmail.com", "123456");
//        return "GrpcStarterClientEurekaApplication! response from grpc server";
    }
}
