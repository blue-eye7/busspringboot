package com.why.BusApp.Service.Bus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.why.BusApp.Entity.Bus.Availability;
import com.why.BusApp.Entity.User.Bookings;
import com.why.BusApp.Entity.User.Passenger;
import com.why.BusApp.Entity.User.User;
import com.why.BusApp.Repository.Bus.AvailabilityRepo;
import com.why.BusApp.Repository.user.Bookingrepo;
import com.why.BusApp.Repository.user.UserRepo;

@Service
public class BookingService {
	
	@Autowired AvailabilityRepo avrepo;
	
	@Autowired UserRepo userrepo;
	
	@Autowired Bookingrepo bookrepo;
	
	
	


	public ResponseEntity<?> book(List<Passenger> pass, Bookings book, long id, long avid) {
		
		Availability availability=avrepo.findById(avid).orElse(null);
		for(Passenger p:pass) {
			p.setBookings(book);
			
		}
		book.getPassengers().addAll(pass);
		
		availability.getBookings().add(book);
		availability.getBooked_seats().addAll(book.getSeats());
		book.setAvailability(availability);
		User u=userrepo.findById(id).orElse(null);
		book.setUser(u);
		u.getBookings().add(book);
//		avrepo.save(availability);
		return ResponseEntity.ok(bookrepo.save(book));
		
	}
}
