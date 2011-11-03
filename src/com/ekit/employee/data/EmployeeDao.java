package com.ekit.employee.data;

import java.util.List;

import com.ekit.employee.data.Employee;

public interface EmployeeDao {

	public void save(Employee employee);
	public void delete(int employeeID);
	public Employee get(int employeeID);
	public List<Employee> getAllEmployees();
}
