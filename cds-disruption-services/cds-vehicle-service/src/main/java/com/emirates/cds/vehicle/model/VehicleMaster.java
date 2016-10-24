package com.emirates.cds.vehicle.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "VEHICLE_MASTER")
public class VehicleMaster {

	String ancilaryfeature;
	String make;
	String model;
	String registrationno;
	String serviceproviderid;

	@DynamoDBAttribute(attributeName = "ancilaryfeature")
	public String getAncilaryfeature() {
		return ancilaryfeature;
	}

	public void setAncilaryfeature(String ancilaryfeature) {
		this.ancilaryfeature = ancilaryfeature;
	}

	@DynamoDBAttribute(attributeName = "MAKE")
	public String getMAKE() {
		return make;
	}

	public void setMAKE(String mAKE) {
		this.make = mAKE;
	}

	@DynamoDBAttribute(attributeName = "MODEL")
	public String getMODEL() {
		return model;
	}

	public void setMODEL(String model) {
		this.model = model;
	}

	@DynamoDBAttribute(attributeName = "registrationno")
	public String getRegistrationno() {
		return registrationno;
	}

	public void setRegistrationno(String registrationno) {
		this.registrationno = registrationno;
	}

	@DynamoDBAttribute(attributeName = "serviceproviderid")
	public String getServiceproviderid() {
		return serviceproviderid;
	}

	public void setServiceproviderid(String serviceproviderid) {
		this.serviceproviderid = serviceproviderid;
	}

}
