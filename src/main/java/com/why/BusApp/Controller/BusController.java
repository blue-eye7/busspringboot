package com.why.BusApp.Controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.why.BusApp.Entity.Bus.Availability;
import com.why.BusApp.Entity.Bus.Bus;
import com.why.BusApp.Entity.User.Bookings;
import com.why.BusApp.Entity.User.Passenger;
import com.why.BusApp.Service.Bus.BookingService;
import com.why.BusApp.Service.Bus.BusService;

@RestController
@RequestMapping("/Busconfig")
@CrossOrigin(origins = "http://localhost:5173")
public class BusController {
	
	
	@Autowired BusService busservice;
	
	@Autowired BookingService bookingservice;
	
	@RequestMapping("/busconfig")
	public ResponseEntity<?> configurebus(@RequestBody BusDtoconfig request ,@RequestParam List<LocalDate> available_dates){
		System.out.println("request recieved");
		
		if(request.getBus()!=null && request.getRoute()!=null && request.getStops()!=null) {
			return busservice.configure(request.getBus(),request.getRoute(),request.getStops(),available_dates);
		}
		
		else if(request.getBus()!=null) {
			return busservice.configure(request.getBus(),available_dates);
		}
		return busservice.configure(request.getRoute(),request.getStops());
		
	}
	@GetMapping("/getbus")
	public ResponseEntity<?> getbuses(){
		System.out.println("get all buses");
		return busservice.getbuses();
	}
	@GetMapping("/getroutes")
	public ResponseEntity<?> getroutes(){
		System.out.println("get all routes");
		return busservice.getroutes();
	}
	
	@PostMapping("/addtobus")
	public ResponseEntity<?> addroutetobus(@RequestParam long busid,@RequestParam int routeid){
		System.out.println("add to bus request");
		return busservice.addroutetobus(busid,routeid);
	} 
	@GetMapping("/getbuses")
	public ResponseEntity<?> getmatchedbus(@RequestParam String busname ,@RequestParam LocalDate journey_date){
		
		 ResponseEntity r=busservice.getmatchedbus(busname,journey_date);// ResponseEntity r=busservice.getmatchedbus("govt")
		 
		
		return  r;
	}
	@PostMapping("/book")
		public ResponseEntity<?> book(@RequestBody BookingDto booking,@RequestParam long id,@RequestParam long avid){
			
			List<Passenger> pass=booking.getPassengers();
			Bookings book=booking.getBookings();
			
			
			return bookingservice.book(pass,book,id,avid);
		}
	@GetMapping("/getseats/{id}")
	public List<Integer> getseats(@PathVariable long id){
		return busservice.getseats(id);
	}
	@GetMapping("getbusbyloc")
	public List<Availability> getbus(@RequestParam String boarding,@RequestParam String destination,@RequestParam LocalDate journey_date){
		return busservice.getbuss(boarding,destination,journey_date);
	}
	
	
}
