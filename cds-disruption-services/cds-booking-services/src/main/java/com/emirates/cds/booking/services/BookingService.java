/**
 * 
 */
package com.emirates.cds.booking.services;

import com.emirates.cds.booking.dao.BookingDAO;
import com.emirates.cds.booking.model.Booking;
import com.emirates.cds.booking.model.BookingResponse;

/**
 * @author Vinod
 *
 */
public class BookingService {
	
	
	public BookingResponse updateBooking(Booking booking) {
		
		BookingDAO dao = new BookingDAO();
		BookingResponse bresponse = new BookingResponse();
		
		bresponse = dao.createBooking(booking);
		return bresponse;
	}

	public Booking getBooking(String tripId) {
		BookingDAO dao = new BookingDAO();
		//BookingResponse bresponse = new BookingResponse();
		
		Booking bresponse = dao.getBooking(tripId);
		return bresponse;
	}

	public BookingResponse updateBooking(String tripId, String vehicleId, String status) {
		BookingDAO dao = new BookingDAO();
		BookingResponse bresponse = new BookingResponse();
		
		bresponse = dao.updateBooking(tripId, vehicleId, status);
		return bresponse;
	}
	
	/*public static void main(String args[]){
		LoginService serv = new LoginService();
		if(serv.verifyLogin("vinod", "vinod")){
			System.out.println("Login Success");
		}
	}*/

}
