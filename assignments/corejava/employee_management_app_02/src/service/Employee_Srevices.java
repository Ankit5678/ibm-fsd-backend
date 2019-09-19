package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Db_Services;
import view.Employee;

public class Employee_Srevices implements IEmployee_Services {
	
	Db_Services db_Service = new Db_Services();
	
	public void viewAllEmployees() {
		ResultSet rs = db_Service.getAllEmployee();
		
		try {
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");

				// Display values
				System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s\n", id, age, name, designation, department, country);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addNewEmp(Employee e) {
		int id = e.getId();
		int age = e.getAge();
		String name = e.getName();
		String department = e.getDept();
		String designation = e.getDesign();
		String country = e.getCountry();
		db_Service.insertNewEmployee(id,age,name,department,designation,country);
	}

}
