package com.crud.operation;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	EmployeeDAO dao = new EmployeeDAO();
	while(true) {
		System.out.println("\n===== Employee Management =====");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employee");
        System.out.println("3. View Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");
        System.out.print("Enter choice:");
        
		switch(sc.nextInt()) {
		
		case 1: {

		    System.out.print("Enter Id: ");
		    int id = sc.nextInt();
		    sc.nextLine(); 

		    System.out.print("Enter Name: ");
		    String name = sc.nextLine();

		    System.out.print("Enter Department: ");
		    String dept = sc.nextLine();

		    System.out.print("Enter Salary: ");
		    double sal = sc.nextDouble();

		    Employee e = new Employee(id, name, dept, sal);
		    dao.insertEmp(e);
		    break;
		    }
		
		case 2:{
			dao.getAllEmployees();
			break;
		 }
		case 3:{
			System.out.println("Enter Employee Id:");
			dao.getEmployee(sc.nextInt());
			break;
		}
		case 4:{
			System.out.println("Enter id to update salary");
			int id = sc.nextInt();
		    System.out.println("Enter Salary:");
		    double sal = sc.nextDouble();
		    dao.updateEmployee(id, sal);
		    break;
		}
		case 5:{
			System.out.println("Enter id:");
			dao.deleteEmployee(sc.nextInt());
			break;
		}
		case 6:{
			System.exit(0);
			break;
		}
		default: {
			System.out.println("Invalid choice");
		}
	}
	
}
 }
}
