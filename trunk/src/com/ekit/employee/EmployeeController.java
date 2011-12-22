package com.ekit.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import com.ekit.util.JSONView;
import com.ekit.util.ParamUtil;



import com.ekit.security.UserDetailsService;
import com.ekit.util.DBVController;
import com.ekit.admin.AdminService;
import com.ekit.employee.data.Employee;

public class EmployeeController extends DBVController{

	
	private UserDetailsService userDetailsService;
	private EmployeeService employeeService;
	private AdminService adminService;
	
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public ModelAndView GetCountries(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HashMap model = new HashMap();
		model.put("countries", adminService.getAllCountriesMapList());
		ModelAndView returnModelAndView = new ModelAndView(new JSONView(), model);
		return returnModelAndView;
	}
	public ModelAndView LoadEmployeeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
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

	public ModelAndView SaveEmployee(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
 
		String jsonData = ParamUtil.getString(request, "jsonData");
		JSONObject jsonObject = new JSONObject(jsonData);
		HashMap userMap = new HashMap();
		Employee emp = null;
		if(ParamUtil.getString(request, "saveType").equals("create")) {
			try {
				
				emp=new Employee();
				emp.setFirstName((String)jsonObject.get("firstName"));
				emp.setLastName((String)jsonObject.get("lastName"));
				emp.setAddress((String)jsonObject.get("address"));
				emp.setCountry((String)jsonObject.get("country"));
				emp.setHomePhone((String)jsonObject.get("homePhone"));
				
				employeeService.saveEmployee(emp);
				userMap.put("success", "true");
			    
			} catch(Exception ex) {
				userMap.put("failure", "true");
			}
		} else {
			try {
			   
				emp =employeeService.getEmployee(Integer.parseInt(jsonObject.get("employeeId").toString()));
				emp.setFirstName((String)jsonObject.get("firstName"));
				emp.setLastName((String)jsonObject.get("lastName"));
				emp.setAddress((String)jsonObject.get("address"));
				emp.setCountry((String)jsonObject.get("country"));
				emp.setHomePhone((String)jsonObject.get("homePhone"));
				
				
				employeeService.saveEmployee(emp);
				userMap.put("success", "true");
			} catch(Exception ex) {
				userMap.put("failure", "true");
			}
		}
		
		ModelAndView userSaveModelAndView = new ModelAndView(new JSONView(), userMap);
		return userSaveModelAndView;
		}
	 public ModelAndView DeleteEmployee(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		HashMap deleteUserMap = new HashMap();
		try {
				 
			employeeService.deleteEmployee(ParamUtil.getInt(request, "employeeId"));
			deleteUserMap.put("success", "true");
		} catch(Exception ex) {
			deleteUserMap.put("failure", "true");
		}
			
		ModelAndView userDeleteModelAndView = new ModelAndView(new JSONView(), deleteUserMap);
		return userDeleteModelAndView;
	}
		
	

}
