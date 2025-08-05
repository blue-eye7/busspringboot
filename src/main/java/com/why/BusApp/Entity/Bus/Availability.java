package com.why.BusApp.Entity.Bus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.why.BusApp.Entity.User.Bookings;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Availability {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDate available_date;
	
	@ElementCollection
	private List<Integer> booked_seats;
	@OneToMany(mappedBy = "availability",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Bookings> bookings=new ArrayList<Bookings>();
	@ManyToOne
	private Bus bus;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getAvailable_date() {
		return available_date;
	}
	public void setAvailable_date(LocalDate available_date) {
		this.available_date = available_date;
	}
	public List<Integer> getBooked_seats() {
		return booked_seats;
	}
	public void setBooked_seats(List<Integer> booked_seats) {
		this.booked_seats = booked_seats;
	}
	public List<Bookings> getBookings() {
		return bookings;
	}
	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
