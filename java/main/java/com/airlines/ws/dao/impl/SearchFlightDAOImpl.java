package com.airlines.ws.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airlines.ws.constants.BookFlight;
import com.airlines.ws.constants.User;
import com.airlines.ws.dao.intf.SearchFlightDAO;
import com.airlines.ws.domain.SearchFlightDTO;
import com.airlines.ws.model.Category;
import com.airlines.ws.model.Flight;
import com.airlines.ws.model.FromLocation;
import com.airlines.ws.model.Signup;

@Transactional
@Repository("searchFlightDAO")
public class SearchFlightDAOImpl implements SearchFlightDAO {

	
	@Autowired
	private HibernateTemplate searchFlightHibernateTemplate;

	
	@Override
	public List<String> getFromLocation() {
		List<FromLocation> countries = searchFlightHibernateTemplate.loadAll(FromLocation.class);

		List<String> fromLocations = new ArrayList<>();
		for(FromLocation country : countries) {
			fromLocations.add(country.getFromLocationName());
		}
		return fromLocations;
	}

	@Override
	public List<String> getToLocation() {
		List<FromLocation> countries = searchFlightHibernateTemplate.loadAll(FromLocation.class);

		List<String> toLocations = new ArrayList<>();
		for(FromLocation country : countries) {
			toLocations.add(country.getFromLocationName());
		}
		return toLocations;
	}


	@Override
	public List<String> getCategories() {
		List<Category> categories = searchFlightHibernateTemplate.loadAll(Category.class);
		
		List<String> categoryList = new ArrayList<>();
		for(Category category : categories)
			categoryList.add(category.getCategoryName());

		return categoryList;
	}

	@Override
	public List<com.airlines.ws.constants.Flight> searchFlight(SearchFlightDTO searchFlightDTO) {
		String from = searchFlightDTO.getFrom();
		String to = searchFlightDTO.getTo();
		
		String query = "From Flight where flightSource = ? and flightDestination = ?";
		List<Flight> flights = (List<Flight>) searchFlightHibernateTemplate.find(query, from, to);
		
		List<com.airlines.ws.constants.Flight> flightDTO = convertToDTO(flights);
		
		return flightDTO;
	}

	private List<com.airlines.ws.constants.Flight> convertToDTO(List<Flight> flights) {
		List<com.airlines.ws.constants.Flight> flightDTO = new ArrayList<>();
		
		for(Flight flight : flights) {
			com.airlines.ws.constants.Flight flightObj = new com.airlines.ws.constants.Flight();
			flightObj.setFlightId(flight.getFlightId());
			flightObj.setFlightDepartureDate(flight.getFlightDepartureDate());
			flightObj.setFlightArrivalDate(flight.getFlightArrivalDate());
			flightObj.setFlightArrival(flight.getFlightArrival());
			flightObj.setFlightDeparture(flight.getFlightDeparture());
			flightObj.setFlightDuration(flight.getFlightDuration());
			flightObj.setFlightName(flight.getFlightName());
			flightObj.setFlightNumber(flight.getFlightNumber());
			flightObj.setFlightPrice(flight.getFlightPrice());
			flightDTO.add(flightObj);
		}
		return flightDTO;
	}

	
	

	
	
	
	/*@Override
	public com.airlines.ws.constants.Flight bookFlight(BookFlight bookFlightId) {
		Flight bookFlight = searchFlightHibernateTemplate.get(Flight.class, bookFlightId.getFlightId());
		com.airlines.ws.constants.Flight bookFlightDTO = convertToDTO(bookFlight);
		return bookFlightDTO;
	}

	private com.airlines.ws.constants.Flight convertToDTO(Flight bookFlight) {
		com.airlines.ws.constants.Flight bookFlightDTO = new com.airlines.ws.constants.Flight();
		bookFlightDTO.setFlightArrival(bookFlight.getFlightArrival());
		bookFlightDTO.setFlightArrivalDate(bookFlight.getFlightDepartureDate());
		bookFlightDTO.setFlightDeparture(bookFlight.getFlightDeparture());
		bookFlightDTO.setFlightDepartureDate(bookFlight.getFlightDepartureDate());
		bookFlightDTO.setFlightDuration(bookFlight.getFlightDuration());
		bookFlightDTO.setFlightId(bookFlight.getFlightId());
		bookFlightDTO.setFlightName(bookFlight.getFlightName());
		bookFlightDTO.setFlightNumber(bookFlight.getFlightNumber());
		bookFlightDTO.setFlightPrice(bookFlight.getFlightPrice());
		
		return bookFlightDTO;
	}*/

}
