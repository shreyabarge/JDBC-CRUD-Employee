package com.crud.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO {
	Connection con = ConnectionProvider.getConnection();
    public void insertEmp(Employee e) {
    	try {
		PreparedStatement ps = con.prepareStatement("insert into employees(id,name,dept,sal) values (?,?,?,?)");
		ps.setInt(1, e.getEmpId());
		ps.setString(2, e.getEmpName());
		ps.setString(3, e.getDepartment());
		ps.setDouble(4, e.getSalary());
		ps.executeUpdate();
		System.out.println("Employee added sucessfully...");
		
		} catch (SQLException excep) {
			
			excep.printStackTrace();
		}
    	
    }
    
    public void getAllEmployees() {
    	try {
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees");
			while(rs.next()) {
				System.out.print(
			    rs.getInt("id") +"|"+
				rs.getString("name") +"|"+
				rs.getString("dept") + "|"+
				rs.getDouble("sal"));
			System.out.println();	
			System.out.println("---------------------------");	
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
    
    public void getEmployee(int id) {
    	try {
			PreparedStatement ps=con.prepareStatement("select * from employees where id = ?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			System.out.println(
					rs.getInt("id") +"|"+
			        rs.getString("name") + "|"+
				    rs.getString("dept") + "|"+
			        rs.getDouble("sal"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    public void updateEmployee(int id, double sal) {
    	try {
			PreparedStatement ps =con.prepareStatement("update employees set sal = ? where id = ?");
			ps.setDouble(1, sal);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void deleteEmployee(int id) {
    	try {
			PreparedStatement ps=con.prepareStatement("delete from employees where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Deleted sucessfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
