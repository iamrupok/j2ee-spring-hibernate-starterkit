package com.ekit.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import com.ekit.util.JSONView;


import com.ekit.security.UserDetailsService;
import com.ekit.util.DBVController;
import com.ekit.employee.data.Employee;

public class EmployeeController extends DBVController{

	
	private UserDetailsService userDetailsService;
	private EmployeeService employeeService;
	
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public ModelAndView LoadEmployeeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//User user = userDetailsService.getUser(request.getRemoteUser());
		
	
		int start = (request.getParameter("start") != null) ? Integer.parseInt(request.getParameter("start")) : 0;
		int limit = (request.getParameter("limit") != null) ? Integer.parseInt(request.getParameter("limit")) : 15;

		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Map<String,String>> employeeList = new ArrayList<Map<String,String>>();
		List<Employee> employee = employeeService.getAllEmployees();
		if(employee!=null && employee.size()>0){
			Iterator<Employee> employeeIt = employee.iterator();
			while(employeeIt.hasNext()){
				employeeList.add(employeeIt.next().getSimpleMemberMap());
			}
		}
		
		
		
		 map.put("employeeList", employeeList.subList(start, start + limit > employeeList.size()?employeeList.size():start + limit));
		 map.put("totalCount", employeeList.size());

		return new ModelAndView(new JSONView(), map);	
	}

	

}
