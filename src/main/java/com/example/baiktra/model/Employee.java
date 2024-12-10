package com.example.baiktra.model;

public class Employee {
    private int ID;
    private String name;
    private int age;
    private String jobPosition ;
    private String department ;
    private double salary ;

    public Employee() {
    }

    public Employee(int ID, String name, int age, String jobPosition, String department, double salary) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.jobPosition = jobPosition;
        this.department = department;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", jobPosition='" + jobPosition + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

}
