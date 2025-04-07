package com.example.Spring_data_jpa_relationship.service;

import com.example.Spring_data_jpa_relationship.model.Employee;
import com.example.Spring_data_jpa_relationship.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void removeEmployee(int id){
        employeeRepo.deleteById(id);
    }
}
