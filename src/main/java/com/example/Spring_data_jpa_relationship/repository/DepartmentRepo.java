package com.example.Spring_data_jpa_relationship.repository;

import com.example.Spring_data_jpa_relationship.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
