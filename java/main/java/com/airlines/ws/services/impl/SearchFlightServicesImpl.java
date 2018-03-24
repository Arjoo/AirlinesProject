package com.airlines.ws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlines.ws.constants.Flight;
import com.airlines.ws.constants.Signup;
import com.airlines.ws.constants.User;
import com.airlines.ws.dao.intf.SearchFlightDAO;
import com.airlines.ws.domain.SearchFlightDTO;
import com.airlines.ws.services.intf.SearchFlightServices;


@Service("searchFlightServices")
public class SearchFlightServicesImpl implements SearchFlightServices {

	@Autowired
	private SearchFlightDAO searchFlightDAO;
	
	@Override
	public List<String> getFromLocation() {
		List<String> fromLocations = searchFlightDAO.getFromLocation();
		return fromLocations;
	}

	@Override
	public List<String> getToLocation() {
		List<String> toLocations = searchFlightDAO.getToLocation();
		return toLocations;
	}

	@Override
	public List<String> getCategories() {
		List<String> categories = searchFlightDAO.getCategories();
		return categories;
	}

	@Override
	public List<Flight> searchFlight(SearchFlightDTO searchFlightDTO) {
		List<Flight> flights = searchFlightDAO.searchFlight(searchFlightDTO);
		return flights;
	}

	

	

}
