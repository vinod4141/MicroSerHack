/**
 * 
 */
package com.emirates.cds.serviceprovider;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.cds.serviceprovider.model.ServiceProvidersResponse;
import com.emirates.cds.serviceprovider.services.ServiceProviderService;



/**
 * @author Vinod
 *
 */
@CrossOrigin
@RestController
public class ServiceProviderController {

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
	@RequestMapping(value="/serviceproviders", method=RequestMethod.GET)
	public ServiceProvidersResponse getServiceProviders(
			@RequestParam(value="tripid") String tripId, 
			@RequestParam(value="flightno") String flightNo,
			@RequestParam(value="paxtype") String paxType, 
			@RequestParam(value="airportcode") String airportCode){
		
		System.out.println("Reached Vehicles Service");
		ServiceProvidersResponse sresponse = new ServiceProvidersResponse();
		ServiceProviderService service = new ServiceProviderService();
		
		
		sresponse = service.getServiceProviders(tripId, flightNo, paxType, airportCode);
		
		
		
		System.out.println("Value Returned is " + sresponse.getStatusMessage());
		return sresponse;
		
	}
}
