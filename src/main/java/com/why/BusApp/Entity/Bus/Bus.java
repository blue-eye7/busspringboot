package com.why.BusApp.Entity.Bus;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String reg_no;
	
	private String owner;
	@OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("bus")
	private List<Availability> availability=new ArrayList<Availability>();
	
	private int total_seats;
	
	private LocalTime depature_time;
	
	private LocalTime arrival_time;
	
	public LocalTime getDepature_time() {
		return depature_time;
	}

	public void setDepature_time(String time) {
		 String[] parts = time.split("\\.");
	        int hours = Integer.parseInt(parts[0]);
	        int minutes = (parts.length > 1) ? Integer.parseInt(parts[1]) : 0;
	        
	        this.depature_time=LocalTime.of(hours, minutes);
	}

	public LocalTime getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String time) {
		 String[] parts = time.split("\\.");
	        int hours = Integer.parseInt(parts[0]);
	        int minutes = (parts.length > 1) ? Integer.parseInt(parts[1]) : 0;
	        
	        this.arrival_time=LocalTime.of(hours, minutes);
	}

	public List<Availability> getAvailability() {
		return availability;
	}

	public void setAvailability(List<Availability> availability) {
		this.availability = availability;
	}

	public void setDepature_time(LocalTime depature_time) {
		this.depature_time = depature_time;
	}

	public void setArrival_time(LocalTime arrival_time) {
		this.arrival_time = arrival_time;
	}

	@ManyToOne
	@JsonIgnoreProperties({"bus"})
	private Route route;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getTotal_seats() {
		return total_seats;
	}

	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	
	
	
	
}
