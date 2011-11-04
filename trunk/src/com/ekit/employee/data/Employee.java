package com.ekit.employee.data;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ekit.util.StringUtil;
import com.ekit.util.data.SimpleMemberMappable;



@Entity
@Table(name = "EMPLOYEE")
public class Employee implements SimpleMemberMappable{

	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue(generator="EmployeeSeq")
    @SequenceGenerator(name="EmployeeSeq",sequenceName="EMPLOYEE_SEQ", allocationSize=1)
	private int employeeId;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="BIRTH_DATE")
	private String birthDate;
	
	@Column(name="HIRE_DATE")
	private String hireDate;
	
	@Column(name="ADRESS")
	private String address;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="REGION")
	private String region;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="HOME_PHONE")
	private String homePhone;
	
	@Column(name="EXTENSION")
	private String extension;
	
	@Column(name="NOTES")
	private String notes;
	
	@Column(name="STATUS")
	private String status;
	
	private String active;
	
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String isActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getActive() {
		return active;
	}
	
	public Map<String, String> getSimpleMemberMap() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("employeeId",StringUtil.nullToZeroLengthStr(""+this.getEmployeeId()));
		map.put("lastName", ""+this.getLastName());
		map.put("firstName", StringUtil.nullToZeroLengthStr(this.getFirstName()));
		map.put("address", StringUtil.nullToZeroLengthStr(this.getAddress()));
		map.put("country", StringUtil.nullToZeroLengthStr(this.getCountry()));
		map.put("city", StringUtil.nullToZeroLengthStr(this.getCity()));
		map.put("region", StringUtil.nullToZeroLengthStr(this.getRegion()));
		map.put("postalCode", StringUtil.nullToZeroLengthStr(this.getPostalCode()));
		map.put("homePhone", StringUtil.nullToZeroLengthStr(this.getHomePhone()));
		map.put("notes", StringUtil.nullToZeroLengthStr(this.getNotes()));
		map.put("hireDate", StringUtil.nullToZeroLengthStr(this.getHireDate()));
		map.put("birthDate", StringUtil.nullToZeroLengthStr(this.getBirthDate()));
		map.put("status", ""+this.getStatus());
		map.put("active", this.isActive());
		map.put("extension", "" + this.getExtension());

		return map;
	}
	
}

