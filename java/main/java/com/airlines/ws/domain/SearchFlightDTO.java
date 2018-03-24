package com.airlines.ws.domain;

import java.sql.Date;

public class SearchFlightDTO {
	
	private boolean isOneWay;
	private String from;
	private String to;
	private int numberOfPassenger;
	private String passengerClass;
	private Date depart;
	private Date rturn;
	
	public SearchFlightDTO() {
		super();
	}
	
	public SearchFlightDTO(boolean isOneWay, String from, String to, int numberOfPassanger, String passengerClass,
			Date depart, Date rturn) {
		super();
		this.isOneWay = isOneWay;
		this.from = from;
		this.to = to;
		this.numberOfPassenger = numberOfPassanger;
		this.passengerClass = passengerClass;
		this.depart = depart;
		this.rturn = rturn;
	}

	public int getNumberOfPassenger() {
		return numberOfPassenger;
	}

	public void setNumberOfPassenger(int numberOfPassenger) {
		this.numberOfPassenger = numberOfPassenger;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public boolean isOneWay() {
		return isOneWay;
	}
	public void setOneWay(boolean isOneWay) {
		this.isOneWay = isOneWay;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getPassengerClass() {
		return passengerClass;
	}
	public void setPassengerClass(String passengerClass) {
		this.passengerClass = passengerClass;
	}

	public Date getDepart() {
		return depart;
	}

	public void setDepart(Date depart) {
		this.depart = depart;
	}

	public Date getRturn() {
		return rturn;
	}

	public void setRturn(Date rturn) {
		this.rturn = rturn;
	}

}
