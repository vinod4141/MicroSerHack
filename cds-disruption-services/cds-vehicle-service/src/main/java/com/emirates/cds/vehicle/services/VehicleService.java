/**
 * 
 */
package com.emirates.cds.vehicle.services;

import com.emirates.cds.vehicle.dao.VehicleDAO;
import com.emirates.cds.vehicle.model.VehicleResponse;

/**
 * @author Vinod
 *
 */
public class VehicleService {
	
	
	

	public VehicleResponse getVehicles(String serviceProviderId, String tripId) {
		
		VehicleDAO dao = new VehicleDAO();
		VehicleResponse vresponse = null;
		
		vresponse = dao.getVehicles(serviceProviderId, tripId);
		return vresponse;
	}
	
	/*public static void main(String args[]){
		LoginService serv = new LoginService();
		if(serv.verifyLogin("vinod", "vinod")){
			System.out.println("Login Success");
		}
	}*/

}
