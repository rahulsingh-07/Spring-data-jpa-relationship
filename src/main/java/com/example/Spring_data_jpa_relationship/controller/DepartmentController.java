package com.example.Spring_data_jpa_relationship.controller;

import com.example.Spring_data_jpa_relationship.model.Employee;
import com.example.Spring_data_jpa_relationship.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/department/{id}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable int id) {
        List<Employee> employees = departmentService.getEmployeesByDepartmentId(id);
        return ResponseEntity.ok(employees);
    }
}
