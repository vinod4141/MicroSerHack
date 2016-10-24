/**
 * 
 */
package com.emirates.cds.cancellation.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.emirates.cds.login.UserDetail;
import com.emirates.cds.login.dao.LoginDAO;

/**
 * @author Vinod
 *
 */
public class BookingService {
	
	public boolean verifyLogin( String userName, String password){
		
		CanellationDAO dao = new CanellationDAO();
		boolean isAuth = false;
		Properties properties = new Properties();
		UserDetail user = null;
		/*try{
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("user.properties").getFile());
			InputStream in = new FileInputStream(file);
			properties.load(in);
			
		} catch (IOException iox){
			iox.printStackTrace();
		}*/
		try {
			user = dao.getUserDetail(userName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		if( user.getPassword() != null){
			if( user.getPassword().equalsIgnoreCase(password)){
				isAuth = true;
			}
		}
		/*if(userName != null && password != null){
			if(properties.containsKey(userName)){
				if(properties.getProperty(userName).equalsIgnoreCase(password)){
					isAuth = true;
				}
			}
		}*/
		return isAuth;
	}
	
	/*public static void main(String args[]){
		LoginService serv = new LoginService();
		if(serv.verifyLogin("vinod", "vinod")){
			System.out.println("Login Success");
		}
	}*/

}
