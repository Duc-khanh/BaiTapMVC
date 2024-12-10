<%@ page import="java.util.List" %>
<%@ page import="com.example.baiktra.model.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.baiktra.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<h1>Danh sach nhan vien</h1>
<br>
<a href="employee?action=add">add view</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ten</th>
        <th>Tuoi</th>
        <th>Vi tri</th>
        <th>Phong ban</th>
        <th>Luong</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${listEmployee}">
        <tr>
            <td>${employee.ID}</td>
            <td>${employee.name}</td>
            <td>${employee.age}</td>
            <td>${employee.jobPosition}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>

            <td>
                <a href="employee?action=edit&id=${employee.ID}">Edit</a>
                <a href="employee?action=delete&id=${employee.ID}" >Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>