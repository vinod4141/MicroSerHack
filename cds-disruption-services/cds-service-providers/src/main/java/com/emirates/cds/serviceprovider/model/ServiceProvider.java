/**
 * 
 */
package com.emirates.cds.serviceprovider.model;

/**
 * @author Vinod
 *
 */
public class ServiceProvider {
	
	private String spCode;
	private String name;
	private String contactNo;
	private String email;
	private String tripId;
	
	public String getSpCode() {
		return spCode;
	}
	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTripId() {
		return tripId;
	}
	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

}
