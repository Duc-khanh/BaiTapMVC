package com.example.baiktra.service;

import com.example.baiktra.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(int id,Employee employee);
    void deleteEmployee(int id);
}


