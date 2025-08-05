package com.why.BusApp.Controller;

import java.util.List;

import com.why.BusApp.Entity.User.Bookings;
import com.why.BusApp.Entity.User.Passenger;

public class BookingDto {
	
	private Bookings bookings;
	
	private List<Passenger> passengers;

	public Bookings getBookings() {
		return bookings;
	}

	public void setBookings(Bookings bookings) {
		this.bookings = bookings;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}


	
	
	
	
}
