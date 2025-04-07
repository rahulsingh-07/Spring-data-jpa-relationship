package com.example.Spring_data_jpa_relationship.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity // Marks this class as a JPA entity mapped to a database table
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@Table(name = "address") // Specifies the table name in the database
public class Address {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key (auto-increment)
    private int id;

    @Column(nullable = false) // Column cannot be null in the database
    private String state;

    @Column(nullable = false) // Column cannot be null in the database
    private String district;

    private String street; // Optional field for street name

    private int houseNumber; // Optional field for house number

    @Column(nullable = false) // Column cannot be null in the database
    private int pincode;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address") // One-to-one relationship with Employee; 'address' is the owning side
    @JsonBackReference // Prevents infinite recursion during JSON serialization
    private Employee employee;
}
