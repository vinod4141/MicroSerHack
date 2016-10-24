/**
 * 
 */
package com.emirates.cds.serviceprovider.model;

import java.util.List;



/**
 * @author Vinod
 *
 */
public class ServiceProvidersResponse {
	private List<ServiceProvider> servicesProviders;
	private String statusCode;
	private String statusMessage;
	public List<ServiceProvider> getServicesProviders() {
		return servicesProviders;
	}
	public void setServicesProviders(List<ServiceProvider> servicesProviders) {
		this.servicesProviders = servicesProviders;
	}
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
}
