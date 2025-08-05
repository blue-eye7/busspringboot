package com.why.BusApp.Controller;

import java.util.List;



import com.why.BusApp.Entity.Bus.Bus;
import com.why.BusApp.Entity.Bus.Route;
import com.why.BusApp.Entity.Bus.Stops;


public class BusDtoconfig {
	
	private Bus bus;
	
	private Route route;
	
	private List<Stops> stops;

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<Stops> getStops() {
		return stops;
	}

	public void setStops(List<Stops> stops) {
		this.stops = stops;
	}
	
	
}
