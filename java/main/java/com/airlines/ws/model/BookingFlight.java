package com.airlines.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookingFlight")
public class BookingFlight {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingId")
	private int bookingId;
	
	@Column(name = "userId")
	private int userId;

	
	@Column(name = "bookingDate")
	private String bookingDate;
	
	@Column(name = "tripDate")
	private String tripDate;
	
	@Column(name = "trip")
	private String trip;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}
	
	
		
}
