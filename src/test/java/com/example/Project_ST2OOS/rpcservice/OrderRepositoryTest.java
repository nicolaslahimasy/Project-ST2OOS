package com.example.Project_ST2OOS.rpcservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.example.Project_ST2OOS.restservice.model.Order;
import com.example.Project_ST2OOS.restservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testOrderSave() {
        Order order = new Order();
        order.setDescription("Test Order");
        orderRepository.save(order);

        assertNotNull(orderRepository.findById(order.getId()));
    }
}
