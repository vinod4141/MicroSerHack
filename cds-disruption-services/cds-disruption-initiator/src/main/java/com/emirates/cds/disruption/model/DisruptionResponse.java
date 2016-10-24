/**
 * 
 */
package com.emirates.cds.disruption.model;

/**
 * @author Vinod
 *
 */
public class DisruptionResponse {
	private String statusCode ;
	private String stausMessage;
	private String actionMessage;
	
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStausMessage() {
		return stausMessage;
	}
	public void setStausMessage(String stausMessage) {
		this.stausMessage = stausMessage;
	}
	public String getActionMessage() {
		return actionMessage;
	}
	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}
}
