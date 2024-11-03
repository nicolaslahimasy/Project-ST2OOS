package com.example.Project_ST2OOS.rpcservice.service;

import com.example.Project_ST2OOS.rpcservice.proto.OrderServiceOuterClass;
import com.example.Project_ST2OOS.rpcservice.proto.OrderServiceGrpc;
import com.example.Project_ST2OOS.restservice.model.Order;
import com.example.Project_ST2OOS.restservice.service.OrderService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderRpcService extends OrderServiceGrpc.OrderServiceImplBase {

    @Autowired
    private OrderService orderService; // Inject your OrderService

    public void GetOrder(OrderServiceOuterClass.OrderRequest request, StreamObserver<OrderServiceOuterClass.OrderResponse> responseObserver) {
        // Fetch order by ID using the injected OrderService
        Long orderId = request.getId();
        Order order = orderService.getOrderById(orderId); // Make sure this method is implemented in OrderService

        OrderServiceOuterClass.OrderResponse.Builder responseBuilder = OrderServiceOuterClass.OrderResponse.newBuilder();

        if (order != null) {
            // Map Order entity to gRPC response
            responseBuilder.setId(order.getId())
                    .setDescription(order.getDescription());
        } else {
            // Handle not found case
            responseBuilder.setId(orderId)
                    .setDescription("Order not found");
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    public void CreateOrder(OrderServiceOuterClass.OrderRequest request, StreamObserver<OrderServiceOuterClass.OrderResponse> responseObserver) {
        // Create a new Order entity using the injected OrderService
        Order order = new Order();
        order.setId(request.getId());
        order.setDescription(request.getDescription());

        Order createdOrder = orderService.createOrder(order); // Ensure this method is implemented in OrderService

        OrderServiceOuterClass.OrderResponse response = OrderServiceOuterClass.OrderResponse.newBuilder()
                .setId(createdOrder.getId())
                .setDescription(createdOrder.getDescription())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
