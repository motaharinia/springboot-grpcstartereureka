package com.motaharinia;

import com.motaharinia.server.user.stub.UserGrpc;
import com.motaharinia.server.user.stub.UserMicro;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-07-01<br>
 * Time: 16:51:36<br>
 * Description:<br>
 */
@Service
public class GrpcClientService {

    @GrpcClient("myClient")
    private UserGrpc.UserBlockingStub simpleStub;

    public String sendMessage(final String name) {
        try {
            UserMicro.LoginRequest loginRequest = UserMicro.LoginRequest.newBuilder().setUsername("user1").setPassword("pass1").build();
//            UserMicro.LoginRequest loginRequest = UserMicro.LoginRequest.newBuilder().setUsername(StringValue.of("user1")).setPassword(StringValue.of("pass1")).build();
            final UserMicro.APIResponse apiResponse= this.simpleStub.login(loginRequest);
            return apiResponse.getResponseMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }

}