package com.motaharinia.grpcclient.business.service;

import com.motaharinia.grpcserver.business.service.user.stub.UserGrpc;
import com.motaharinia.grpcserver.business.service.user.stub.UserMicro;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//https://github.com/LogNet/grpc-spring-boot-starter


/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-07-01<br>
 * Time: 16:51:36<br>
 * Description:<br>
 */
@Service
public class GrpcClientService {

    @Autowired
    private EurekaClient client;


    public String sendMessage(final String username,final String password) {
        try {
            final InstanceInfo instanceInfo = client.getNextServerFromEureka("GrpcStarterServer", false);
            System.out.println("GrpcStarterServer instanceInfo.getIPAddr():"+instanceInfo.getIPAddr()+ " instanceInfo.getPort():"+instanceInfo.getPort());
            final ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
            final UserGrpc.UserBlockingStub userBlockingStub = UserGrpc.newBlockingStub(channel);

            UserMicro.LoginRequest loginRequest = UserMicro.LoginRequest.newBuilder().setUsername(username).setPassword(password).build();
//            UserMicro.LoginRequest loginRequest = UserMicro.LoginRequest.newBuilder().setUsername(StringValue.of("user1")).setPassword(StringValue.of("pass1")).build();
            final UserMicro.APIResponse apiResponse= userBlockingStub.login(loginRequest);
            return apiResponse.getResponseMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }


//    @GrpcClient("myClient")
//    private UserGrpc.UserBlockingStub userBlockingStub;
//
//    public String sendMessage(final String username,final String password) {
//        try {
//            UserMicro.LoginRequest loginRequest = UserMicro.LoginRequest.newBuilder().setUsername(username).setPassword(password).build();
////            UserMicro.LoginRequest loginRequest = UserMicro.LoginRequest.newBuilder().setUsername(StringValue.of("user1")).setPassword(StringValue.of("pass1")).build();
//            final UserMicro.APIResponse apiResponse= this.userBlockingStub.login(loginRequest);
//            return apiResponse.getResponseMessage();
//        } catch (final StatusRuntimeException e) {
//            return "FAILED with " + e.getStatus().getCode().name();
//        }
//    }

}