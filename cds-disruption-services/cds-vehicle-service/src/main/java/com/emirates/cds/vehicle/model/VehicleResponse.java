/**
 * 
 */
package com.emirates.cds.vehicle.model;

import java.util.List;

/**
 * @author Vinod
 *
 */
public class VehicleResponse {

	private List<Vehicles> vehicles;
	private String statusCode;
	private String statusMessage;
	
	
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
	public List<Vehicles> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}
}
