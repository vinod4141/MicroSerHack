/**
 * 
 */
package com.emirates.cds.disruption.services;


import com.emirates.cds.disruption.model.Disruption;
import com.emirates.cds.disruption.model.DisruptionResponse;

/**
 * @author Vinod
 *
 */

public class DisruptionService {
	
	
	
	
	public DisruptionResponse initiateDisruption(Disruption disruption) {
		
		DisruptionResponse dresponse = new DisruptionResponse();
		
		// identify customers
		//Notify customers about the delay
		// Start Rebooking and disruption flow
		dresponse.setStatusCode("0");
		dresponse.setStausMessage("Success");
		dresponse.setActionMessage("Customer Notified,  Started Disruption flow");
		return dresponse;
	}
	
	
}
