package com.airlines.ws.services.intf;

import java.util.List;

import com.airlines.ws.constants.Flight;
import com.airlines.ws.constants.Signup;
import com.airlines.ws.constants.User;
import com.airlines.ws.domain.SearchFlightDTO;

public interface SearchFlightServices {
	
	public List<String> getFromLocation();
	
	public List<String> getToLocation();
	
	public List<String> getCategories();

	public List<Flight> searchFlight(SearchFlightDTO searchFlightDTO);

	

}
