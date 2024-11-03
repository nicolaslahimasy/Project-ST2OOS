package com.example.Project_ST2OOS.restservice.model;

import jakarta.persistence.*;

// This annotation indicates that the class is an entity and is mapped to a database table
@Entity
@Table(name = "orders") // Specify the table name if you want to customize it
public class Order {

    // Unique identifier for the Order, generated automatically
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Description of the Order
    @Column(nullable = false, length = 255) // Adding constraints
    private String description;

    // Default constructor
    public Order() {}

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
