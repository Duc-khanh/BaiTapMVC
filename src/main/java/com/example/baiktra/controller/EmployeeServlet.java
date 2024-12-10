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
            default:
                showEmployee(request, response);
                break;

        }
    }

    private void showEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> listEmployee = employeeService.getAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}
