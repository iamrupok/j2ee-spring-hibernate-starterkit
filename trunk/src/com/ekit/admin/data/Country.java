package com.ekit.admin.data;

import java.util.HashMap;
import java.util.Map;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ekit.util.data.SimpleMemberMappable;
import com.ekit.util.StringUtil;
/**
 * Entity model for Country information
 */
@Entity
@Table(name = "COUNTRY")
public class Country implements SimpleMemberMappable {
    
	@Id
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ISO_CODE")
	private String isoCode;
	
	@Column(name="DISPLAY_ORDER")
	private int displayOrder;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Map<String, String> getSimpleMemberMap() {
	
		Map<String,String> map = new HashMap<String,String>();		
		
		map.put("id", StringUtil.nullToZeroLengthStr(""+this.getId()));
		map.put("name", StringUtil.nullToZeroLengthStr(this.getName()));
		map.put("isoCode", StringUtil.nullToZeroLengthStr(""+this.getIsoCode()));
		map.put("displayOrder", StringUtil.nullToZeroLengthStr(""+this.getDisplayOrder()));		
		
		return map;
	}
	
	
	

}

