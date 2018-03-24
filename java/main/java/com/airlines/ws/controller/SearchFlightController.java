package com.airlines.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airlines.ws.constants.Flight;
import com.airlines.ws.constants.Signup;
import com.airlines.ws.constants.User;
import com.airlines.ws.domain.SearchFlightDTO;
import com.airlines.ws.services.intf.SearchFlightServices;

@Component
@RestController
public class SearchFlightController {

	@Autowired
	private SearchFlightServices searchFlightServices;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/fromLocations", method = RequestMethod.GET)
	public List<String> getFromLocation() {
		List<String> fromLocations = searchFlightServices.getFromLocation();
		System.out.println("size   ======== "  +fromLocations.size());
		return fromLocations;
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/toLocations", method = RequestMethod.GET)
	public List<String> getToLocations() {
		List<String> toLocations = searchFlightServices.getToLocation();
		System.out.println("size   ======== "  +toLocations.size());
		return toLocations;
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public List<String> getCategories() {
		List<String> categories = searchFlightServices.getCategories();
		return categories;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/searchFlight",method = RequestMethod.POST,
			produces = { "application/json", "application/xml" })
	public List<Flight> searchFlight(@RequestBody SearchFlightDTO searchFlightDTO) {
		List<Flight> flights = searchFlightServices.searchFlight(searchFlightDTO);
		return flights;
	}
	
	
	
}