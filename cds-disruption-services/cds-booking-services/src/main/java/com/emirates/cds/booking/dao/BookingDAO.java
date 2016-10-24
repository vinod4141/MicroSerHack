/**
 * 
 */
package com.emirates.cds.booking.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.emirates.cds.booking.model.Booking;
import com.emirates.cds.booking.model.BookingResponse;


/**
 * @author Vinod
 *
 */

public class BookingDAO {

	static AmazonDynamoDBClient dynamoDBClient = null;
	static DynamoDB dynamoDB = null;
	static String tableName = "CDTRIP";

	 private static void init() throws Exception {
	        /*
	        
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
			dynamoDBClient = new AmazonDynamoDBClient(credentials);
			Region APSE = Region.getRegion(Regions.AP_SOUTHEAST_1);
			dynamoDBClient.setRegion(APSE);
			dynamoDB = new DynamoDB(dynamoDBClient);
			
	    }

	 public BookingResponse updateBooking(String tripid, String vehicleid,String status) {
			
			try {
				init();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			BookingResponse bresponse = new BookingResponse();
			
						
			try {

	   	            
	           /* Insert Rudra Code Here  */
	       	 Map<String, String> expressionAttributeNames = new HashMap<String, String>();
	         expressionAttributeNames.put("#na", "vehicleid");
	         expressionAttributeNames.put("#nb", "status");

	         UpdateItemSpec updateItemSpec = new UpdateItemSpec()
	         .withPrimaryKey("tripid", tripid)
	         .withUpdateExpression("set #na = :val1 , #nb = :val2")
	         .withNameMap(new NameMap()
	             .with("#na", "vehicleid").with("#nb", "status"))
	         .withValueMap(new ValueMap()
	             .withString(":val1", vehicleid).withString(":val2", status))
	         .withReturnValues(ReturnValue.ALL_NEW);
	         Table table = dynamoDB.getTable(tableName);
	         UpdateItemOutcome outcome =  table.updateItem(updateItemSpec);

	         // Check the response.
	         System.out.println("Printing item after adding new attribute...");
	         System.out.println(outcome.getItem().toJSONPretty());  
	         bresponse.setTripId(tripid);
	         bresponse.setStatusCode("0");
			 bresponse.setStatusMessage("Success");

	        } catch (AmazonServiceException ase) {
	            System.out.println("Caught an AmazonServiceException, which means your request made it "
	                    + "to AWS, but was rejected with an error response for some reason.");
	            System.out.println("Error Message:    " + ase.getMessage());
	            System.out.println("HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("Error Type:       " + ase.getErrorType());
	            System.out.println("Request ID:       " + ase.getRequestId());
	            bresponse.setTripId(tripid);
		         bresponse.setStatusCode("1");
				 bresponse.setStatusMessage("Failure");
	        } catch (AmazonClientException ace) {
	            System.out.println("Caught an AmazonClientException, which means the client encountered "
	                    + "a serious internal problem while trying to communicate with AWS, "
	                    + "such as not being able to access the network.");
	            System.out.println("Error Message: " + ace.getMessage());
	            bresponse.setTripId(tripid);
		         bresponse.setStatusCode("1");
				 bresponse.setStatusMessage("Failure");
	        } catch (Exception e) {
				
				e.printStackTrace();
				bresponse.setTripId(tripid);
		         bresponse.setStatusCode("1");
				 bresponse.setStatusMessage("Failure");
			}
			
			return bresponse;
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

	public Booking getBooking(String tripId) {

		
		try {
			init();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	 	    
	    Table table = dynamoDB.getTable("CDTRIP"); 
        
        QuerySpec querySpec = new QuerySpec()
            .withKeyConditionExpression("tripid = :spv").withValueMap(new ValueMap()
                    .withString(":spv", tripId)
                    );               

        ItemCollection<QueryOutcome> items = table.query(querySpec);

        Iterator<Item> iterator = items.iterator();
        Item item = null;

       
        Booking booking = null;
        while (iterator.hasNext()) {
            item = iterator.next();
            booking = new Booking();
            booking.setPnr(item.getString("pnr"));
            booking.setPassenger(item.getString("pax"));
         
            booking.setNoofbaggages(item.getString("noofbaggages"));
            
            booking.setFlighno(item.getString("flightno"));
            booking.setDestination(item.getString("destination"));
            booking.setAirport(item.getString("airport"));
            booking.setPaxCount(item.getString("noofpax"));
            booking.setStatus(item.getString("status"));
            booking.setVehicleid(item.getString("vehicleid"));
        }
       
        return booking;
		
	}


	public BookingResponse createBooking(Booking trip) {
		try {
			init();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BookingResponse bresponse = new BookingResponse();
		String tripId = getSaltString();

		try {
			
			Table table = dynamoDB.getTable(tableName);
			
		
			ArrayList<String> listAttr = new ArrayList<String>();
			listAttr.add("pnr");
			listAttr.add("flightno");
			listAttr.add("noofbaggages");
			listAttr.add("pax");
			listAttr.add("noofpax");
			listAttr.add("pickuptime");
			listAttr.add("destinaiton");
			listAttr.add("tripid");

			

				try {
					Item items = new Item();
					items.withPrimaryKey("tripid", tripId);
					items.withString("pnr", trip.getPnr());
					items.withString("flightno", trip.getFlighno());
					items.withString("noofbaggages", trip.getNoofbaggages().toString());
					items.withString("pax", trip.getPassenger());
					items.withString("paxcount", trip.getPaxCount());
					items.withString("pickuptime", trip.getPickuptime());
					items.withString("destination", trip.getDestination());
					items.withString("airport", trip.getAirport());
					PutItemOutcome outcome = table.putItem(items);
					outcome.getPutItemResult();

				} catch (Exception e) {
					System.err.println("Unable to add Item: " + tripId + " ");
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bresponse.setTripId(tripId);
		bresponse.setStatusCode("0");
		bresponse.setStatusMessage("Success");
		
		return bresponse;
	}
}
