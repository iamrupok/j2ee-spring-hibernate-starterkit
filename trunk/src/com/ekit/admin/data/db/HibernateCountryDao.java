package com.ekit.admin.data.db;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ekit.admin.data.Country;
import com.ekit.admin.data.CountryDao;

/**
 * Hibernate implementation of CountryDao
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Repository
public class HibernateCountryDao implements CountryDao {
   
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * Sets HibernateTemplate instance to hibernateTemplate object (through dependency injection)
	 *
	 * @param jpaTemplate
	 */
	public void setJpaTemplate(HibernateTemplate jpaTemplate) {
		this.hibernateTemplate = jpaTemplate;
	}

	/**
	 * Retrieves all Countries
	 * 
	 * @return list of Country objects
	 */
	@SuppressWarnings("unchecked")
	public List<Country> getAllCountries() {
		List<Country> returnList = hibernateTemplate.find("from Country order by displayOrder");
		return returnList;
	}

	/**
	 * Retrieves a particular Country object for given countryId
	 * 
	 * @param countryId
	 * @return Country object
	 */
	public Country getCountry(int countryId) {
		Country country = (Country)hibernateTemplate.get(Country.class, countryId);
		return country;
	}
	

}

