package com.ekit.admin;

import java.util.List;
import java.util.Map;

import com.ekit.admin.data.Country;



public interface  AdminService {

	public List<Country> getAllCountries();
	public Country getCountry(int countryId);
	public List<Map> getAllCountriesMapList();
	
}
