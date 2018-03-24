package com.airlines.ws.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airlines.ws.constants.BookFlight;
import com.airlines.ws.constants.User;
import com.airlines.ws.dao.intf.FlightBookingDAO;
import com.airlines.ws.dto.BookingFlightDTO;
import com.airlines.ws.model.BookingFlight;
import com.airlines.ws.model.Flight;
import com.airlines.ws.model.Signup;

@Transactional
@Repository("flightBookingDAO")
public class FlightBookingDAOImpl implements FlightBookingDAO {
	
	@Autowired
	private HibernateTemplate flightBookingHibernateTemplate;
	
	@Override
	public com.airlines.ws.constants.Signup findUserByEmail(User userObj) {
		Signup signinUser = flightBookingHibernateTemplate.get(Signup.class, userObj.getUserId());
		com.airlines.ws.constants.Signup siUser = null;
		if(signinUser != null )
			siUser = convertToDTO(signinUser);
		
		return siUser;
	}
	
	@Override
	public com.airlines.ws.constants.Flight findFlightById(BookFlight bookFlight) {
		Flight flight = flightBookingHibernateTemplate.get(Flight.class, bookFlight.getFlightId());
		com.airlines.ws.constants.Flight flightDTO = null;
		if(flight != null )
			flightDTO = convertFlightToDTO(flight);
		
		return flightDTO;
	}
	
	@Override
	public BookingFlightDTO bookTicket(BookingFlightDTO bookingFlightDTO) {
		BookingFlight bookingFlight = convertIntoModel(bookingFlightDTO);
		
		Integer bookingId = (Integer)flightBookingHibernateTemplate.save(bookingFlight);
		System.out.println("bookingId is from DAOImpl::: " + bookingId); 
		bookingFlightDTO.setBookingId(bookingId);
		return bookingFlightDTO;
	}
	
	@Override
	public List<BookingFlightDTO> getBookedFlights(User user) {
		String query = "from BookingFlight bf where bf.userId= :userId";
		UserId valueBean = new UserId(user.getUserId());
		List<BookingFlight> bookedFlights = (List<BookingFlight>) flightBookingHibernateTemplate.findByValueBean(query, valueBean);
		List<BookingFlightDTO> bookedFlightsDTO = convertIntoDTO(bookedFlights);
		return bookedFlightsDTO;
	}
	
	private List<BookingFlightDTO> convertIntoDTO(List<BookingFlight> bookedFlights) {
		List<BookingFlightDTO> bookedFlightsDTO = new ArrayList<BookingFlightDTO>();
		
		for(BookingFlight bookingFlight : bookedFlights) {
			BookingFlightDTO dto = new BookingFlightDTO();
			dto.setBookingDate(bookingFlight.getBookingDate());
			dto.setBookingId(bookingFlight.getBookingId());
			dto.setTrip(bookingFlight.getTrip());
			dto.setTripDate(bookingFlight.getTripDate());
			dto.setUserId(bookingFlight.getUserId());
			bookedFlightsDTO.add(dto);
		}
		return bookedFlightsDTO;
	}

	private BookingFlight convertIntoModel(BookingFlightDTO bookingFlightDTO) {
		BookingFlight bookingFlight = new BookingFlight();
		bookingFlight.setBookingDate(bookingFlightDTO.getBookingDate());
		bookingFlight.setTrip(bookingFlightDTO.getTrip());
		bookingFlight.setTripDate(bookingFlightDTO.getTripDate());
		bookingFlight.setUserId(bookingFlightDTO.getUserId());
		return bookingFlight;
	}

	
	
	private com.airlines.ws.constants.Flight convertFlightToDTO(Flight flight) {
		com.airlines.ws.constants.Flight flightDTO = new com.airlines.ws.constants.Flight();
		flightDTO.setFlightId(flight.getFlightId());
		flightDTO.setFlightDepartureDate(flight.getFlightDepartureDate());
		flightDTO.setFlightArrivalDate(flight.getFlightArrivalDate());
		flightDTO.setFlightArrival(flight.getFlightArrival());
		flightDTO.setFlightDeparture(flight.getFlightDeparture());
		flightDTO.setFlightDuration(flight.getFlightDuration());
		flightDTO.setFlightName(flight.getFlightName());
		flightDTO.setFlightNumber(flight.getFlightNumber());
		flightDTO.setFlightPrice(flight.getFlightPrice());
		flightDTO.setFlightSource(flight.getFlightSource());
		flightDTO.setFlightDestination(flight.getFlightDestination());
		
		return flightDTO;
	}

	private com.airlines.ws.constants.Signup convertToDTO(Signup signinUser) {
		com.airlines.ws.constants.Signup siUser = new com.airlines.ws.constants.Signup();
		siUser.setConfirmpassword(signinUser.getConfirmpassword());
		siUser.setCountry(signinUser.getCountry());
		siUser.setEmail(signinUser.getEmail());
		siUser.setFirstname(signinUser.getFirstname());
		siUser.setId(signinUser.getId());
		siUser.setLastname(signinUser.getLastname());
		siUser.setMiddlename(signinUser.getMiddlename());
		siUser.setMobile(signinUser.getMobile());
		siUser.setPassword(signinUser.getPassword());
		return siUser;
	}

}


class UserId {
	private int userId;
	
	public UserId() {
		super();
	}
	public UserId(int userId) {
		super();
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
