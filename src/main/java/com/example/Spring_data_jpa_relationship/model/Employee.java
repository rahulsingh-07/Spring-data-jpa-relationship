package com.example.Spring_data_jpa_relationship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity // Marks this class as a JPA entity (maps to a database table)
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode
@AllArgsConstructor // Lombok: generates a constructor with all fields
@NoArgsConstructor // Lombok: generates a no-argument constructor
@Table(name = "employee") // Specifies the table name in the database
public class Employee {

    @Id // Marks the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates primary key values
    private int id;

    @Column(nullable = false) // Cannot be null in the database
    private String name;

    @Column(nullable = false, unique = true) // Cannot be null and must be unique
    private String email;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE) // Specifies that only the date (not time) should be stored
    private Date birthdate;

    @Column(nullable = false)
    private String role;

    // One-to-one relationship with Address
    // CascadeType.ALL: any operation (persist, remove, etc.) on Employee will affect Address
    // JsonIgnore to avoid infinite recursion during JSON serialization
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") // Defines the foreign key column name
    @JsonIgnore
    private Address address;

    // Many employees can belong to one department
    // JsonIgnore to prevent recursive loops in JSON response
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    // Many-to-many relationship with Project
    // A join table "employee_project" will be created with employee_id and project_id
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    @JsonIgnore // Prevent recursive JSON nesting
    private List<Project> projects;
}
