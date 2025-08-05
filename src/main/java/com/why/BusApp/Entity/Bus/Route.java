package com.why.BusApp.Entity.Bus;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String starting_point;
	
	private String ending_point;
	
	private int distance;
	
	private double time;
	
	private String via;
	
	@OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("route")
	private List<Bus> bus=new ArrayList<Bus>();
	
	@OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("route")
	private List<Stops> stops=new ArrayList<Stops>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStarting_point() {
		return starting_point;
	}

	public void setStarting_point(String starting_point) {
		this.starting_point = starting_point;
	}

	public String getEnding_point() {
		return ending_point;
	}

	public void setEnding_point(String ending_point) {
		this.ending_point = ending_point;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}

	public List<Stops> getStops() {
		return stops;
	}

	public void setStops(List<Stops> stops) {
		this.stops = stops;
	}
	 
}
