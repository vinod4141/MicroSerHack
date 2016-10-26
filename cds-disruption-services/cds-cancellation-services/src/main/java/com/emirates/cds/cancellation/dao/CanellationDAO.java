/**
 * 
 */
package com.emirates.cds.cancellation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

/**
 * @author Vinod
 *
 */

public class CanellationDAO {

	private static AmazonDynamoDBClient dynamoDB;

	/*public UserDetail getUserDetail(String name) throws Exception{
		setClient();
		UserDetail user = new UserDetail();
		user.setUserName(name);
		try {
            String tableName = "CDUser";
            HashMap<String, Condition> scanFilter = new HashMap<String, Condition>();
            Condition condition = new Condition()
            		.withComparisonOperator(ComparisonOperator.EQ.toString())
            		.withAttributeValueList(new AttributeValue().withS(name));
            scanFilter.put("username", condition);
            ScanRequest scanRequest = new ScanRequest(tableName).withScanFilter(scanFilter);
            ScanResult scanResult = dynamoDB.scan(scanRequest);
            List<Map<String,AttributeValue>>  values = scanResult.getItems();
            if(values != null){
            	for(Map<String, AttributeValue> mapValue : values){
            		for (Entry<String, AttributeValue> entry : mapValue.entrySet()) {
                       
                        if(entry.getKey().equalsIgnoreCase("password")){
                        	user.setPassword(entry.getValue().getS());
                        }
                    }
            	}
            }
            System.out.println("Result: " + scanResult);

        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means your request made it "
                    + "to AWS, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with AWS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
    
		
		return user;
	}
*/
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
	}

}
