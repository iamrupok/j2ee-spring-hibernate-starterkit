package com.ekit.employee;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ekit.employee.EmployeeService;
import com.ekit.employee.data.Employee;
import com.ekit.employee.data.EmployeeDao;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Employee getEmployee(int employeeID) {				
		return employeeDao.get(employeeID);
	}
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveEmployee(Employee employee) {
		
		employeeDao.save(employee);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteEmployee(int employeeID) {
			 employeeDao.delete(employeeID);
	}
}

