/**
 * 
 */
package com.emirates.cds.vehicle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.cds.vehicle.model.VehicleResponse;
import com.emirates.cds.vehicle.model.Vehicles;
import com.emirates.cds.vehicle.services.VehicleService;

/**
 * @author Vinod
 *
 */
@CrossOrigin
@RestController
public class VehicleController {
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
	@RequestMapping(value="/vehicles", method=RequestMethod.GET)
	public VehicleResponse getVehicles(
			@RequestParam(value="serviceproviderid") String serviceProviderId, 
			@RequestParam(value="tripid") String tripId){
		
		System.out.println("Reached Vehicles Service");
		VehicleResponse bookingResponse = new VehicleResponse();
		VehicleService service = new VehicleService();
		
		if(serviceProviderId != null){
			bookingResponse = service.getVehicles(serviceProviderId, tripId);
		}
		
		
		System.out.println("Value Returned is " + bookingResponse.getStatusMessage());
		return bookingResponse;
		
	}

}