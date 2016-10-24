/**
 * 
 */
package com.emirates.cds.eligibility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.cds.eligibility.model.Eligibility;
import com.emirates.cds.eligibility.model.EligibilityResponse;
import com.emirates.cds.eligibility.service.EligibilityService;



/**
 * @author Vinod
 *
 */
@CrossOrigin
@RestController
public class EligibilityController {
	
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
	@RequestMapping("/eligibility")
	public EligibilityResponse getEligibility(
	        @RequestBody Eligibility eligibility){
		
		System.out.println("Reached Eligibility Service");
		EligibilityResponse eligibilityResponse = new EligibilityResponse();
		EligibilityService service = new EligibilityService();
		
		if(eligibility != null){
			eligibilityResponse = service.checkEligibility(eligibility);
		}
		
		
		System.out.println("Value Returned is " + eligibilityResponse.getMessage());
		return eligibilityResponse;
		
	}

}
