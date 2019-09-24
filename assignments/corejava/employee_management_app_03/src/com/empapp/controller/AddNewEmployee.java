package com.empapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empapp.dao.Db_Services;
import com.empapp.model.Employee;
import com.empapp.services.Employee_Srevices;

/**
 * Servlet implementation class AddNewEmployee
 */
@WebServlet("/AddNewEmployee")
public class AddNewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	//Db_Services db = new Db_Services();
    	//System.out.println("DB instance created - " + db);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String department = request.getParameter("dept");
		String designation = request.getParameter("desig");
		String country = request.getParameter("country");
//		System.out.println("start");
//		System.out.println(Db_Services.conn);
		Employee e = new Employee(name,age,department,designation,country);
		Employee_Srevices eSrevices = new Employee_Srevices();
		
		eSrevices.addNewEmp(e);
		System.out.println("inserted");
	}

}
