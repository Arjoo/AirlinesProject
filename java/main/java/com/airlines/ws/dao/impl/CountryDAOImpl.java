package com.airlines.ws.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airlines.ws.constants.Country;
import com.airlines.ws.dao.intf.CountryDAO;

@Transactional
@Repository("countryDAO")
public class CountryDAOImpl implements CountryDAO {

	@Autowired
	private HibernateTemplate countryHibernateTemplate;
	
	@Override
	public List<Country> getCountry() {
		List<com.airlines.ws.model.Country> countries = 
				countryHibernateTemplate.loadAll(com.airlines.ws.model.Country.class);
		
		List<Country> countriesDAO = convertModelToDAO(countries);
		return countriesDAO;
	}
	
	private List<Country> convertModelToDAO(List<com.airlines.ws.model.Country> countries) {
		List<Country> countryDAO = new ArrayList<>();
		for(com.airlines.ws.model.Country country : countries) {
			Country c = new Country();
			c.setId(country.getId());
			c.setName(country.getName());
			countryDAO.add(c);
		}
		return countryDAO;
	}

}
