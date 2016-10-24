/**
 * 
 */
package com.emirates.cds.serviceprovider.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import com.emirates.cds.serviceprovider.dao.ServiceProviderDAO;
import com.emirates.cds.serviceprovider.model.ServiceProvider;
import com.emirates.cds.serviceprovider.model.ServiceProvidersResponse;


/**
 * @author Vinod
 *
 */
public class ServiceProviderService {
	
	
		
		public ServiceProvidersResponse getServiceProviders(String tripId, String flightNo,
				String paxType, String airportCode) {
			
			ServiceProviderDAO dao = new ServiceProviderDAO();
			ServiceProvidersResponse sresponse = new ServiceProvidersResponse();
			//List<ServiceProvider> providers = new ArrayList<ServiceProvider>();
			try {
				sresponse = dao.getServiceProviders(tripId, flightNo, paxType, airportCode);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			//sresponse.setServicesProviders(providers);
			//sresponse.setStatusCode("0");	
			//sresponse.setStatusMessage("Success");
			return sresponse;
		}

}
