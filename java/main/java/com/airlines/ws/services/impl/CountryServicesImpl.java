package com.airlines.ws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlines.ws.constants.Country;
import com.airlines.ws.dao.intf.CountryDAO;
import com.airlines.ws.services.intf.CountryServices;

@Service
public class CountryServicesImpl implements CountryServices {

	
	@Autowired
	private CountryDAO countryDAO;
	
	@Override
	public List<Country> getCountry() {
		return countryDAO.getCountry();
	}

}
