package com.example.Spring_data_jpa_relationship.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // Marks this class as a JPA entity to be persisted in the database
@Data // Lombok annotation to generate getters, setters, toString, etc.
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-argument constructor
@Table(name = "department") // Maps this entity to the "department" table in the DB
public class Department {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private int id;

    @Column(nullable = false, unique = true) // Column must have a value and should be unique
    private String name;

    // One department can have many employees
    // 'mappedBy' indicates that the 'department' field in Employee owns the relationship
    // CascadeType.ALL means operations like persist, merge, delete will cascade to employees
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonBackReference // Prevents infinite recursion during JSON serialization
    private List<Employee> employeeList;
}
