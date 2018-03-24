package com.airlines.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airlines.ws.constants.BookFlight;
import com.airlines.ws.constants.Flight;
import com.airlines.ws.constants.Signup;
import com.airlines.ws.constants.User;
import com.airlines.ws.dto.BookingFlightDTO;
import com.airlines.ws.services.intf.FlightBookingServices;

@Component
@RestController
public class FlightBookingController {
	
	@Autowired
	private FlightBookingServices flightBookingServices;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/user", method = RequestMethod.POST,
			produces = { "application/json", "application/xml" })
	public Signup user(@RequestBody User user) {
		System.out.println("user id ----------------------------- "  + user.getUserId());
		Signup siUser = flightBookingServices.findUserByEmail(user);
		return siUser;
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/flight", method = RequestMethod.POST,
			produces = { "application/json", "application/xml" })
	public Flight user(@RequestBody BookFlight bookFlight) {
		System.out.println("book flight id----------------------------- "  + bookFlight.getFlightId());
		Flight flightDTO = flightBookingServices.findFlightById(bookFlight);
		return flightDTO;
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/bookTicket", method = RequestMethod.POST,
			produces = { "application/json", "application/xml" })
	public BookingFlightDTO bookTicket(@RequestBody BookingFlightDTO bookingFlightDTO) {
		System.out.println("bookingFlightDTO.getTrip()----------------------------- "  + bookingFlightDTO.getTrip());
		bookingFlightDTO = flightBookingServices.bookTicket(bookingFlightDTO);
		System.out.println("Booking id ----- " + bookingFlightDTO.getBookingId());
		return bookingFlightDTO;
	}
	
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/bookedFlights", method = RequestMethod.POST,
			produces = { "application/json", "application/xml" })
	public List<BookingFlightDTO> getBookedFlights(@RequestBody User user) {
		System.out.println(" user.getUserId()----------------------------- "  + user.getUserId());
		List<BookingFlightDTO> bookingFlightDTO = flightBookingServices.getBookedFlights(user);
	
		return bookingFlightDTO;
	}

}
