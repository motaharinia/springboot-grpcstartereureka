package com.motaharinia.server.user;


import com.motaharinia.server.user.stub.UserGrpc;
import com.motaharinia.server.user.stub.UserMicro;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserService extends UserGrpc.UserImplBase {
    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void login(UserMicro.LoginRequest request, StreamObserver<UserMicro.APIResponse> responseObserver) {
        System.out.println("login username:" + request.getUsername() + " password:" + request.getPassword());
        UserMicro.APIResponse.Builder response = UserMicro.APIResponse.newBuilder();
        if(request.getUsername().isEmpty() || request.getPassword().isEmpty()){
            response.setResponseCode(400);
            response.setResponseMessage("Username or password is blank");
        }else{
            response.setResponseCode(200);
            response.setResponseMessage("Success");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void logout(UserMicro.Empty request, StreamObserver<UserMicro.APIResponse> responseObserver) {
        super.logout(request, responseObserver);
    }
}
