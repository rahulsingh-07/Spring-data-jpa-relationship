package com.example.Spring_data_jpa_relationship.controller;

import com.example.Spring_data_jpa_relationship.model.Employee;
import com.example.Spring_data_jpa_relationship.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployee(){
        return employeeService.getAllEmployee();
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        employeeService.removeEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
