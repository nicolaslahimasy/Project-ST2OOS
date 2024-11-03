package com.example.Project_ST2OOS.rpcservice;

import com.example.Project_ST2OOS.rpcservice.service.OrderRpcService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class RpcServiceApplication {
    private Server server;

    @Autowired
    private OrderRpcService orderRpcService; // Inject the OrderRpcService

    @PostConstruct
    public void start() throws Exception {
        server = ServerBuilder.forPort(50051)
                .addService(orderRpcService) // Use the injected service
                .build()
                .start();
        System.out.println("gRPC server started on port 9090");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server");
            RpcServiceApplication.this.stop();
        }));
        try {
            server = ServerBuilder.forPort(9090)
                    .addService(orderRpcService)
                    .build()
                    .start();
            System.out.println("gRPC server started on port 9090");
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception
        }
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
}
