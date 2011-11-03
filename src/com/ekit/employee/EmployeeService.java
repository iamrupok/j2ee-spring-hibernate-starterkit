package com.ekit.employee;

import java.util.List;
import com.ekit.employee.data.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(int EmployeeId);
	public List<Employee> getAllEmployees();
	public void saveEmployee(Employee employee);
	public void deleteEmployee(int EmployeeId);
	
}