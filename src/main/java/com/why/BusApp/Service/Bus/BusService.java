package com.why.BusApp.Service.Bus;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.why.BusApp.Entity.Bus.Availability;
import com.why.BusApp.Entity.Bus.Bus;
import com.why.BusApp.Entity.Bus.Route;
import com.why.BusApp.Entity.Bus.Stops;
import com.why.BusApp.Repository.Bus.AvailabilityRepo;
import com.why.BusApp.Repository.Bus.BusRepo;
import com.why.BusApp.Repository.Bus.RouteRepo;

@Service
public class BusService {
	
	@Autowired BusRepo busrepo;
	@Autowired RouteRepo routerepo;
	@Autowired AvailabilityRepo avrepo;

	public ResponseEntity<?> configure(Bus bus, Route route, List<Stops> stops,List<LocalDate> dates) {
		
		for (Stops stop : stops) {
	        stop.setRoute(route);
	    }
		for(LocalDate ad:dates) {
			Availability av=new Availability();
			av.setAvailable_date(ad);
			av.setBus(bus);
			bus.getAvailability().add(av);
		}
		route.setStops(stops);
		bus.setRoute(route);
		route.getBus().add(bus);
		routerepo.save(route);
		return ResponseEntity.status(HttpStatus.CREATED).body(bus); 
	}

	public ResponseEntity<?> configure(Bus bus,List<LocalDate> dates) {
		for(LocalDate ad:dates) {
			Availability av=new Availability();
			av.setAvailable_date(ad);
			av.setBus(bus);
			bus.getAvailability().add(av);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(busrepo.save(bus));
	
	}

	public ResponseEntity<?> configure(Route route, List<Stops> stops) {
		System.out.println(route.getEnding_point());
		  for (Stops stop : stops) {
		        stop.setRoute(route);
		    }
		route.setStops(stops);
		return ResponseEntity.status(HttpStatus.CREATED).body(routerepo.save(route));
		
	}

	public ResponseEntity<?> getbuses() {
		List<Bus> bus=busrepo.findAll();
		return ResponseEntity.ok(bus);
	}

	public ResponseEntity<?> getroutes() {
		List<Route> route=routerepo.findAll();
		return ResponseEntity.ok(route);
	}

	public ResponseEntity<?> addroutetobus(long busid, int routeid) {
		Bus bus=busrepo.getById(busid);
		Route route=routerepo.getById(routeid);
		bus.setRoute(route);
		route.getBus().add(bus);
		routerepo.save(route);
		
		return ResponseEntity.ok("added");
	}

	public ResponseEntity<?> getmatchedbus(String busname,LocalDate journey_date) {
		List<Availability> matchedbus =  busrepo.findBusesByNameAndDate(busname,journey_date);
	
			return ResponseEntity.ok(matchedbus);
		
		
	}

	public List<Integer> getseats(long id) {
		Availability a=avrepo.findById(id).orElse(null);
		return a.getBooked_seats();
	}

	public List<Availability> getbuss(String boarding, String destination, LocalDate journey_date) {
		List<Bus> b=busrepo.getBusByRoute(boarding,destination);
		List<Availability> matchedAvailability = b.stream()
			    .flatMap(bus -> bus.getAvailability().stream()) 
			    .filter(a -> a.getAvailable_date().isEqual(journey_date))
			    .collect(Collectors.toList());
		System.out.println(matchedAvailability);
		
		return matchedAvailability;
	}
}
