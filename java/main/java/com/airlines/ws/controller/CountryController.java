package com.airlines.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airlines.ws.constants.Country;
import com.airlines.ws.services.intf.CountryServices;

@Component
@RestController
public class CountryController {

	
	@Autowired
	private CountryServices countryServices;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/countries", 
			method = RequestMethod.GET, 
			produces = { "application/json", "application/xml" })
	public List<Country> getCountry() {
		List<Country> countries = countryServices.getCountry();
		System.out.println("fetching countries    " + countries.size());
		/*List<Country> countries = new ArrayList<Country>();
		countries.add(new Country(1, "India"));
		countries.add(new Country(2, "Australia"));*/
		return countries;
	}
}
