package com.example.baiktra.controller;



import com.example.baiktra.model.Employee;
import com.example.baiktra.service.EmployeeService;
import com.example.baiktra.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "add":
                showNewForm(request, response);
                break;
            default:
                showEmployee(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void showEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> listEmployee = employeeService.getAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String jobPosition = request.getParameter("position");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int id = (int) (Math.random() * 10000);
        Employee newEmployee = new Employee(id, name, age, jobPosition, department, salary);
        employeeService.addEmployee(newEmployee);
        response.sendRedirect("employee");
    }


}
