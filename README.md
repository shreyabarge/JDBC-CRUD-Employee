# 🧑‍💼 JDBC CRUD Employee Management System

A simple Java console-based CRUD application using JDBC and MySQL.

## Features
- Add Employee
- View All Employees
- View Employee by ID
- Update Employee Salary
- Delete Employee

## Technologies Used
- Java 17
- JDBC
- MySQL

## Database Setup
```sql
CREATE DATABASE companydb;
USE companydb;
CREATE TABLE employees (
  id INT PRIMARY KEY,
  name VARCHAR(50),
  dept VARCHAR(50),
  sal DOUBLE
);

