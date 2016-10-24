/**
 * 
 */
package com.emirates.cds.booking;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.cds.booking.model.Booking;
//import com.emirates.cds.booking.service.Boo;
import com.emirates.cds.booking.model.BookingResponse;
import com.emirates.cds.booking.services.BookingService;

/**
 * @author Vinod
 *
 */
@CrossOrigin
@RestController
public class BookingController {
	@CrossOrigin
	@RequestMapping(value ="/", method=RequestMethod.HEAD)
	@ResponseStatus(HttpStatus.OK)
	public void health(){
		
	}
	@CrossOrigin
	@RequestMapping(value ="/", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getHealth(){
		return ("Success");
	}
	
	@CrossOrigin
	@RequestMapping(value="/booking", method=RequestMethod.POST)
	public BookingResponse createBooking(
	        @RequestBody Booking booking){
		
		System.out.println("Reached Eligibility Service");
		BookingResponse bookingResponse = new BookingResponse();
		BookingService service = new BookingService();
		
		if(booking != null){
			bookingResponse = service.updateBooking(booking);
		}
		
		
		System.out.println("Value Returned is " + bookingResponse.getStatusMessage());
		return bookingResponse;
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/booking", method=RequestMethod.GET)
	public Booking getBooking(
			@RequestParam(value="tripid") String tripId){
		
		System.out.println("Reached Eligibility Service");
		Booking booking = null;
		BookingService service = new BookingService();
		
		if(tripId != null){
			booking = service.getBooking(tripId);
		}
		
		
		//System.out.println("Value Returned is " + booking.getStatusMessage());
		return booking;
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/booking", method=RequestMethod.PUT)
	public BookingResponse updateBooking(
			@RequestParam(value="tripid") String tripId,
			@RequestParam(value="vehicleid") String vehicleId,
			@RequestParam(value="status") String status){
		
		System.out.println("Reached Eligibility Service");
		BookingResponse bookingResponse = new BookingResponse();
		BookingService service = new BookingService();
		
		if(vehicleId != null){
			bookingResponse = service.updateBooking(tripId, vehicleId, status);
		}
		
		
		System.out.println("Value Returned is " + bookingResponse.getStatusMessage());
		return bookingResponse;
		
	}

}