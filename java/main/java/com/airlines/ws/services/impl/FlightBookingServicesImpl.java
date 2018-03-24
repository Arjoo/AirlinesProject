package com.airlines.ws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlines.ws.constants.BookFlight;
import com.airlines.ws.constants.Flight;
import com.airlines.ws.constants.Signup;
import com.airlines.ws.constants.User;
import com.airlines.ws.dao.intf.FlightBookingDAO;
import com.airlines.ws.dto.BookingFlightDTO;
import com.airlines.ws.services.intf.FlightBookingServices;

@Service("flightBookingServices")
public class FlightBookingServicesImpl implements FlightBookingServices {

	
	@Autowired
	private FlightBookingDAO flightBookingDAO;
	
	@Override
	public Signup findUserByEmail(User user) {

		return flightBookingDAO.findUserByEmail(user);
	}

	@Override
	public Flight findFlightById(BookFlight bookFlight) {
		return flightBookingDAO.findFlightById(bookFlight);
	}

	@Override
	public BookingFlightDTO bookTicket(BookingFlightDTO bookingFlightDTO) {
		return flightBookingDAO.bookTicket(bookingFlightDTO);
	}

	@Override
	public List<BookingFlightDTO> getBookedFlights(User user) {
		return flightBookingDAO.getBookedFlights(user);
		
	}
}
