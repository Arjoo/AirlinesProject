package com.airlines.ws.constants;

import java.sql.Date;

public class Flight {
	
	private int flightId;
	private String flightNumber;
	private String flightName;
	private Date flightDepartureDate;
	private Date flightArrivalDate;
	private String flightDeparture;
	private String flightArrival;
	private String flightDuration;
	private Double flightPrice;
	private String flightSource;
	private String flightDestination;
	
	
	public Flight() {
		super();
	}
	
	public Flight(int flightId, String flightNumber, String flightName, Date flightDepartureDate,
			Date flightArrivalDate, String flightDeparture, String flightArrival, String flightDuration,
			Double flightPrice, String flightSource, String flightDestination) {
		super();
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.flightDepartureDate = flightDepartureDate;
		this.flightArrivalDate = flightArrivalDate;
		this.flightDeparture = flightDeparture;
		this.flightArrival = flightArrival;
		this.flightDuration = flightDuration;
		this.flightPrice = flightPrice;
		this.flightSource = flightSource;
		this.flightDestination = flightDestination;
	}



	public String getFlightSource() {
		return flightSource;
	}



	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}



	public String getFlightDestination() {
		return flightDestination;
	}



	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}



	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Date getFlightDepartureDate() {
		return flightDepartureDate;
	}

	public void setFlightDepartureDate(Date flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}


	public Date getFlightArrivalDate() {
		return flightArrivalDate;
	}


	public void setFlightArrivalDate(Date flightArrivalDate) {
		this.flightArrivalDate = flightArrivalDate;
	}


	public String getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}

	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightDeparture() {
		return flightDeparture;
	}
	public void setFlightDeparture(String flightDeparture) {
		this.flightDeparture = flightDeparture;
	}
	public String getFlightArrival() {
		return flightArrival;
	}
	public void setFlightArrival(String flightArrival) {
		this.flightArrival = flightArrival;
	}
	public Double getFlightPrice() {
		return flightPrice;
	}
	public void setFlightPrice(Double flightPrice) {
		this.flightPrice = flightPrice;
	}
	

	
}
