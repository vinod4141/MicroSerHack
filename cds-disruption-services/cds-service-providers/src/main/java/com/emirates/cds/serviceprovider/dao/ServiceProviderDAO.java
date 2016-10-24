/**
 * 
 */
package com.emirates.cds.serviceprovider.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.emirates.cds.serviceprovider.model.ServiceProvider;
import com.emirates.cds.serviceprovider.model.ServiceProvidersResponse;


/**
 * @author Vinod
 *
 */

public class ServiceProviderDAO {

	private static AmazonDynamoDBClient dynamoDB;
	private static DynamoDB dynamoDBObj = null;

	
	
	
	public ServiceProvidersResponse getServiceProviders(String tripId, String flightno,
			String paxType, String airportcode) throws Exception{
		setClient();
		
		
		ServiceProvider sprovider = new ServiceProvider();
		//sprovider.setSpCode("S98080");
		List<ServiceProvider> spList = new ArrayList<ServiceProvider>();
		spList.add(sprovider);
		ServiceProvidersResponse serviceProvidersResponse = new ServiceProvidersResponse();

		try {
			setClient();
			String tableName = "SERVICEPROVIDER_MASTER";


			Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
	        eav.put(":val1", new AttributeValue().withS(airportcode));
	        eav.put(":val2", new AttributeValue().withS(flightno));
	        
	 	    
		    Table table = dynamoDBObj.getTable(tableName); 

	        Map<String, Object> valueMap = new HashMap<String, Object>();
	        valueMap.put(":fnv", flightno);
	        valueMap.put(":acv", airportcode);
	        
	        QuerySpec querySpec = new QuerySpec()
	            .withKeyConditionExpression("airportcode = :acv and flightno = :fnv").withValueMap(new ValueMap()
	                    .withString(":acv", airportcode)
	                    .withString(":fnv", flightno)
	                    ) ;               
	               // .withConsistentRead(true).withProjectionExpression("spcode");
	        ItemCollection<QueryOutcome> items = table.query(querySpec);

	        Iterator<Item> iterator = items.iterator();
	        Item item = null;
	        List<ServiceProvider> respnse = new ArrayList<ServiceProvider>();
	       
	        while (iterator.hasNext()) {
	            item = iterator.next();
	            ServiceProvider serviceProvider = new ServiceProvider();
	            serviceProvider.setContactNo(item.getString("contactno"));
	            serviceProvider.setEmail(item.getString("email"));
	            serviceProvider.setName(item.getString("name"));
	            serviceProvider.setSpCode(item.getString("spcode"));
	            respnse.add(serviceProvider);
	            System.out.println(item);
	           
	        }
	        
	       
	      
	        serviceProvidersResponse.setServicesProviders(respnse);
	        serviceProvidersResponse.setStatusCode("0");
	        serviceProvidersResponse.setStatusMessage("Success");
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
		} catch(

				AmazonClientException ace)

		{
			System.out.println("Caught an AmazonClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with AWS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
			serviceProvidersResponse.setStatusCode("1");
	        serviceProvidersResponse.setStatusMessage("Failure");
		} catch(

				Exception e)
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			serviceProvidersResponse.setStatusCode("1");
	        serviceProvidersResponse.setStatusMessage("Failure");
		}

		 return serviceProvidersResponse;
	
	}


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

}
