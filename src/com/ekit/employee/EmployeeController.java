package com.ekit.employee;

import com.ekit.security.UserDetailsService;
import com.ekit.util.DBVController;

public class EmployeeController extends DBVController{

	
	private UserDetailsService userDetailsService;
	private EmployeeService employeeService;
	
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
