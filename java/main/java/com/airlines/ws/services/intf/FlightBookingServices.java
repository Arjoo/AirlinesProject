package com.airlines.ws.services.intf;

import java.util.List;

import com.airlines.ws.constants.BookFlight;
import com.airlines.ws.constants.Flight;
import com.airlines.ws.constants.Signup;
import com.airlines.ws.constants.User;
import com.airlines.ws.dto.BookingFlightDTO;

public interface FlightBookingServices {
	
	public Signup findUserByEmail(User user);

	public Flight findFlightById(BookFlight bookFlight);

	public BookingFlightDTO bookTicket(BookingFlightDTO bookingFlightDTO);

	public List<BookingFlightDTO> getBookedFlights(User user);

}
