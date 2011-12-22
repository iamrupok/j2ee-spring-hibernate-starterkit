package com.ekit.admin.data;

import java.util.List;


/**
 * Interface to access the implementations of HibernateCountryDao 
 */
public interface CountryDao {
	public List<Country> getAllCountries();
	public Country getCountry(int countryId);
	
}
