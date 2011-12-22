package com.ekit.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ekit.admin.data.Country;
import com.ekit.admin.data.CountryDao;

public class AdminServiceImpl implements AdminService {

	private CountryDao countryDao;
	
	public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}
	
	public List<Country> getAllCountries() {
		List<Country> returnList = countryDao.getAllCountries();
		return returnList;
	}
	public Country getCountry(int countryId) {
		Country returnCountry = countryDao.getCountry(countryId);
		return returnCountry;
	}
	public List<Map> getAllCountriesMapList() {
		List<Map> countryMapList = null;
		List<Country> countries = countryDao.getAllCountries();
		
		if(countries != null) {
			countryMapList = new ArrayList<Map>();
			for(Country country : countries) {
				countryMapList.add(country.getSimpleMemberMap());
			}
		}
		return countryMapList;
	}
}
