package com.ekit.employee.data.db;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ekit.employee.data.Employee;
import com.ekit.employee.data.EmployeeDao;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Repository
public class HibernateEmployeeDao implements EmployeeDao {

	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Employee employee){
		hibernateTemplate.merge(employee);		
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(int employeeId){
		
		Employee j = get(employeeId);
		if(j != null)
			hibernateTemplate.delete(j);
		
		
	}
	
	public Employee get(int employeeId){
		
		Employee employee = (Employee)hibernateTemplate.get(Employee.class, employeeId);
		return employee;
	}
	public List<Employee> getAllEmployees() {
		return hibernateTemplate.find("from Employee");
	}


}
