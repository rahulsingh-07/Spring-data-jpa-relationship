package com.example.Spring_data_jpa_relationship.service;

import com.example.Spring_data_jpa_relationship.model.Department;
import com.example.Spring_data_jpa_relationship.model.Employee;
import com.example.Spring_data_jpa_relationship.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    // Get all employees by department ID
    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        Optional<Department> optionalDepartment = departmentRepo.findById(departmentId);

        if (optionalDepartment.isPresent()) {
            return optionalDepartment.get().getEmployeeList();
        } else {
            throw new RuntimeException("Department not found with id: " + departmentId);
        }
    }
}
