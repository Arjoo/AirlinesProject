package com.airlines.ws.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;
	
	@Column(name = "flightNumber")
	private String flightNumber;
	
	@Column(name = "flightName")
	private String flightName;
	
	@Column(name = "flightDepartureDate")
	private Date flightDepartureDate;
	
	@Column(name = "flightArrivalDate")
	private Date flightArrivalDate;
	
		
	@Column(name = "flightDeparture")
	private String flightDeparture;
	
	@Column(name = "flightArrival")
	private String flightArrival;
	
	@Column(name = "flightDuration")
	private String flightDuration;
	
	@Column(name = "flightPrice")
	private Double flightPrice;
	
	@Column(name = "flightSource")
	private String flightSource;
	
	@Column(name = "flightDestination")
	private String flightDestination;
	

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
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

	public String getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}

	public Double getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(Double flightPrice) {
		this.flightPrice = flightPrice;
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
}
