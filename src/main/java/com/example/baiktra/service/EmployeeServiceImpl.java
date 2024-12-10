package com.example.baiktra.service;

import com.example.baiktra.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class EmployeeServiceImpl implements EmployeeService {
    private static final Map<Integer, Employee> employees = new HashMap<>();

    static {
        employees.put(1, new Employee(1, "duckhanh", 23, "Developer", "IT", 20000000));
        employees.put(2, new Employee(2, "chianh", 24, "Developer", "IT", 10000000));
        employees.put(3, new Employee(3, "dan", 25, "Developer", "IT", 199000));
        employees.put(4, new Employee(4, "tam", 26, "Developer", "IT", 1000));
    }

        @Override
        public List<Employee> getAllEmployee() {
            return new ArrayList<>(employees.values());
        }

        @Override
        public Employee getEmployeeById(int id) {
            return employees.get(id);
        }

        @Override
        public void addEmployee(Employee employee) {
            employees.put(employee.getID(), employee);
        }

        @Override
        public void updateEmployee(int id, Employee employee) {
            employees.put(employee.getID(), employee);
        }

        @Override
        public void deleteEmployee(int id) {
            employees.remove(id);
        }
}
