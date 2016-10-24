/**
 * 
 */
package com.emirates.cds.vehicle.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.emirates.cds.vehicle.model.VehicleResponse;
import com.emirates.cds.vehicle.model.Vehicles;

/**
 * @author Vinod
 *
 */

public class VehicleDAO {

	private static AmazonDynamoDBClient dynamoDB;
	private static DynamoDB dynamoDBObj = null;

	private void setClient() throws Exception {
		/*
		 * The ProfileCredentialsProvider will return your [default] credential
		 * profile by reading from the credentials file located at
		 * (~/.aws/credentials).
		 */
		AWSCredentials credentials = null;
		try {
			credentials = InstanceProfileCredentialsProvider.getInstance().getCredentials();
		} catch (Exception e) {

			System.out.println("Cannot load the credentials from the credential profiles file. "
					+ "Please make sure that your credentials file is at the correct "
					+ "location (~/.aws/credentials), and is in valid format.");
			credentials = new ProfileCredentialsProvider().getCredentials();

		}
		dynamoDB = new AmazonDynamoDBClient(credentials);
		Region APSE = Region.getRegion(Regions.AP_SOUTHEAST_1);
		dynamoDB.setRegion(APSE);
		dynamoDBObj = new DynamoDB(dynamoDB);
	}

	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 8) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public VehicleResponse getVehicles(String spcode, String tripId) {
		VehicleResponse vresponse = new VehicleResponse();

		/*Vehicles vehicles = new Vehicles();
		vehicles.setVehicleno("D98080");
		List<Vehicles> vehicleList = new ArrayList<Vehicles>();
		vehicleList.add(vehicles);
		vresponse.setStatusCode("0");
		vresponse.setStatusMessage("Success");
		vresponse.setVehicles(vehicleList);*/

		try {
			setClient();
			String tableName = "VEHICLE_MASTER";

			//tripId = getSaltString();
			/* Insert Rudra Code Here  */


			Table table = dynamoDBObj.getTable(tableName);
			
			 QuerySpec querySpec = new QuerySpec()
			            .withKeyConditionExpression("serviceproviderid = :spv").withValueMap(new ValueMap()
			                    .withString(":spv", spcode)
			                    );

			 ItemCollection<QueryOutcome> items = table.query(querySpec);

		        Iterator<Item> iterator = items.iterator();
		        Item item = null;

		        System.out.println("Movies from 1985");
		       // Vehicles vehicleMaster = new Vehicles();
		        List<Vehicles> vehiclesCol = new ArrayList<Vehicles>();
		        while (iterator.hasNext()) {
		            item = iterator.next();
		            Vehicles vehicleMaster = new Vehicles();
		            vehicleMaster.setServiceproviderid(item.getString("serviceproviderid"));
		            vehicleMaster.setVehicleno(item.getString("vehicleno"));
		            vehicleMaster.setMake(item.getString("MAKE"));
		            vehicleMaster.setModel(item.getString("MODEL"));
		            vehicleMaster.setAncilaryfeature(item.getString("ancilaryfeature"));
		            vehicleMaster.setNoofbaggages(new Integer(item.getString("noofbaggages")));
		            vehicleMaster.setNoofpassenger(new Integer(item.getString("noofpassenger")));
		            vehiclesCol.add(vehicleMaster);
		        }
		    	vresponse.setStatusCode("0");
				vresponse.setStatusMessage("Success");
		        vresponse.setVehicles(vehiclesCol);
		

		}catch(

				AmazonServiceException ase)

		{
			System.out.println("Caught an AmazonServiceException, which means your request made it "
					+ "to AWS, but was rejected with an error response for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
			vresponse.setStatusCode("1");
			vresponse.setStatusMessage("Success");
		} catch(

				AmazonClientException ace){
				vresponse.setStatusCode("1");
				vresponse.setStatusMessage("Success");
		
			System.out.println("Caught an AmazonClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with AWS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
			vresponse.setStatusCode("1");
			vresponse.setStatusMessage("Success");
		} catch(Exception e)

		{
			
			vresponse.setStatusCode("1");
			vresponse.setStatusMessage("Failure");
			e.printStackTrace();
		}

		return vresponse;
	}

}
