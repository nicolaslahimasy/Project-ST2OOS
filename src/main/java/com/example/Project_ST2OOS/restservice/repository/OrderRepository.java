package com.example.Project_ST2OOS.restservice.repository;

import com.example.Project_ST2OOS.restservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("orderRepositoryAlternative")
public interface OrderRepository extends JpaRepository<Order, Long> {
}
