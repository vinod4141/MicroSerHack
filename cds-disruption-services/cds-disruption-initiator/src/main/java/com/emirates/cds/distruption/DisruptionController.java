/**
 * 
 */
package com.emirates.cds.distruption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.cds.disruption.model.Disruption;
import com.emirates.cds.disruption.model.DisruptionResponse;
import com.emirates.cds.disruption.services.DisruptionService;

/**
 * @author Vinod
 *
 */
@CrossOrigin
@RestController
public class DisruptionController {
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
	@RequestMapping(value="/disruption", method=RequestMethod.POST)
	public DisruptionResponse initiateDisruption(
	        @RequestBody Disruption disruption){
		
		System.out.println("Reached Distruption Service");
		DisruptionResponse dresponse = null;
		DisruptionService service = new DisruptionService();
		
		if(disruption != null){
			dresponse = service.initiateDisruption(disruption);
		}
		
		
		System.out.println("Value Returned is " + dresponse.getActionMessage());
		return dresponse;
		
	}
	
	

}