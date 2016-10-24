/**
 * 
 */
package com.emirates.cds.booking.model;

/**
 * @author Vinod
 *
 */
public class BookingResponse {

	private String tripId;
	private String statusCode;
	private String statusMessage;
	
	public String getTripId() {
		return tripId;
	}
	public void setTripId(String tripId) {
		this.tripId = tripId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
