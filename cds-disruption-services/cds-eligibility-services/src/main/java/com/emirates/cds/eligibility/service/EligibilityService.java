/**
 * 
 */
package com.emirates.cds.eligibility.service;

import com.emirates.cds.eligibility.dao.EligibilityDAO;
import com.emirates.cds.eligibility.model.Eligibility;
import com.emirates.cds.eligibility.model.EligibilityResponse;

/**
 * @author Vinod
 *
 */
public class EligibilityService {

	
	EligibilityDAO dao = new EligibilityDAO();

	public EligibilityResponse checkEligibility(Eligibility eligibility) {
		
		EligibilityResponse eResponse = new EligibilityResponse();
		
		if(eligibility.getPassenger().equalsIgnoreCase("AType")){
			eResponse.setEligible(true);
			eResponse.setTripId(eligibility.getTripid());
			eResponse.setMessage("Default Eligible ");
		} else if( Integer.parseInt(eligibility.getDistance())<31){
			eResponse.setEligible(true);
			eResponse.setTripId(eligibility.getTripid());
			eResponse.setMessage(" Eligible based on KM");
		} else {
			eResponse.setEligible(false);
			eResponse.setTripId(eligibility.getTripid());
			eResponse.setMessage("Default Not Eligible ");
		}
		// Update DB.
		if(dao.updateDecision( eligibility, eResponse)){
			System.out.println("Update Successfull");
		}
		
		return eResponse;
	}
	
}
