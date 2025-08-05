package com.why.BusApp.Entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.why.BusApp.Entity.Bus.Availability;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Bookings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String boarding;
	
	private String destination;
	
	private LocalDateTime booking_date=LocalDateTime.now();
	
	private String status;
	
	private int no_ofseats;
	
	@ElementCollection
	private List<Integer> seats=new ArrayList<Integer>();
	
	private double amount;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "bookings",cascade = CascadeType.ALL)
	private List<Passenger> passengers=new ArrayList<Passenger>();
	
	@ManyToOne
	private Availability availability;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBoarding() {
		return boarding;
	}

	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(LocalDateTime booking_date) {
		this.booking_date = booking_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNo_ofseats() {
		return no_ofseats;
	}

	public void setNo_ofseats(int no_ofseats) {
		this.no_ofseats = no_ofseats;
	}

	public List<Integer> getSeats() {
		return seats;
	}

	public void setSeats(List<Integer> seats) {
		this.seats = seats;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	
	
}
