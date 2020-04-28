/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cisco.jasper;

import com.cisco.jasper.util.RestUtils;
import net.sf.json.JSONObject;

/**
 * A Class for demonstrating the Devices API.  
 * @author Santosh Singh
 * @since 03.20.2020
 */

public class Devices {
	
	static final String STATUS_ACTIVATED = "ACTIVATED";
	static final String STATUS_DEACTIVATED = "DEACTIVATED";	
	static final String API_END_POINT_DEVICES = "https://rws-jpotest.jasperwireless.com/rws/api/v1/devices";
	
	public static void main(String arg[]){		
		
		getDevices();
		//changeDevicestatus();		
	}
	
	/**
	 * Returns the list of devices from your account
	 */
	public static void getDevices(){
		//Add the last modified date parameter
		String url = API_END_POINT_DEVICES+"?modifiedSince=2016-04-18T17:31:34+00:00&pageSize=2";		
		//Get list of devices in your account
		JSONObject jsonResponse = RestUtils.executeGet(url);
		System.out.println(jsonResponse);	
	}

	/**
	 * Alters the status of device
	 */	
	public static void changeDevicestatus(){
		
		//This is sample iccid, change it as per your device
		String iccid = "90661079243000311398";
		
		//Pass the ICCID 
		String url = API_END_POINT_DEVICES+"/"+iccid;
		
		//Get device Details
		JSONObject jsonResponse = RestUtils.executeGet(url);
		
		//Check status
		String status = jsonResponse.get("status").toString();
		System.out.println("Current status of device is "+status);
		
		//Change status  		
		if(status.equals(STATUS_DEACTIVATED)){
			//Device is deactivated			
			//Invoking API to activate the device
			String requestJson = "{\"status\": \"ACTIVATED\"}";
		    JSONObject jsonRequest = JSONObject.fromObject(requestJson);	    
		    jsonResponse = RestUtils.executePut(url, jsonRequest);
		    //Deactivation successful 
		    System.out.println("Device activated.."+jsonResponse.toString());
		    getDeviceDetails(iccid);
		}else if(status.equals(STATUS_ACTIVATED)){
			//Device is activated
			//Invoking API to deactivate the device
			String requestJson = "{\"status\": \"DEACTIVATED\"}";
		    JSONObject jsonRequest = JSONObject.fromObject(requestJson);	    
		    jsonResponse = RestUtils.executePut(url, jsonRequest);
		    //Device is activated 
		    System.out.println("Device deactivated.."+jsonResponse.toString());
		    getDeviceDetails(iccid);
		}else{
			System.out.println("Unhandled device status:"+status);
		}    	    
	    
	}
	
	public static void getDeviceDetails(String iccid){		
		//Pass the ICCID in request
		String url = API_END_POINT_DEVICES+"/"+iccid;    
		//Get device Details
		JSONObject jsonResponse = RestUtils.executeGet(url);
		System.out.println(jsonResponse.toString());
	}
	

}
