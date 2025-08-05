package com.why.BusApp.Entity.Bus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Stops {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String stop_name;
	
	private int distance_from_origin;
	
	private int stop_no;
	
	@ManyToOne
	@JsonIgnoreProperties({"stops", "bus"})
	private Route route;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStop_name() {
		return stop_name;
	}

	public void setStop_name(String stop_name) {
		this.stop_name = stop_name;
	}

	public int getDistance_from_origin() {
		return distance_from_origin;
	}

	public void setDistance_from_origin(int distance_from_origin) {
		this.distance_from_origin = distance_from_origin;
	}

	public int getStop_no() {
		return stop_no;
	}

	public void setStop_no(int stop_no) {
		this.stop_no = stop_no;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	
	
}
