package com.example.baiktra.controller;
import com.example.baiktra.model.Employee;
import com.example.baiktra.service.EmployeeService;
import com.example.baiktra.service.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
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
            case "delete":
                deleteEmployee(request, response);
                break;
            case "edit":
                showUpdate(request, response);
                break;
            default:
                showEmployee(request, response);
                break;
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID=Integer.parseInt(request.getParameter("ID"));
        Employee employee =employeeService.getEmployeeById(ID);
        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher =request.getRequestDispatcher("employee.jsp");
        dispatcher.forward(request,response);


    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int ID = Integer.parseInt((request.getParameter("ID")));
        employeeService.deleteEmployee(ID);
        response.sendRedirect("employee");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addEmployee":
                addEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            default:
                showEmployee(request, response);
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int ID= Integer.parseInt(request.getParameter("ID"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String jobPosition = request.getParameter("jobPosition");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));
        Employee employee = employeeService.getEmployeeById(ID);
        employee.setName(name);
        employee.setAge(age);
        employee.setJobPosition(jobPosition);
        employee.setDepartment(department);
        employee.setSalary(salary);
        response.sendRedirect("/employee");
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
        int ID = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String jobPosition = request.getParameter("position");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));
        Employee newEmployee = new Employee(ID, name, age, jobPosition, department, salary);
        employeeService.addEmployee(newEmployee);
        response.sendRedirect("employee?action=view");

    }


}
