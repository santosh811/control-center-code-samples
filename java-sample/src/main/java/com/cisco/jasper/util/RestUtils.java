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
package com.cisco.jasper.util;

import java.net.InetSocketAddress;

import java.net.Proxy;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONObject;

/**
 * A utility class for invoking a REST end point.  
 * @author Santosh Singh
 * @since 03.20.2020
 */

public class RestUtils {

	/**
	 * Execute a GET request
	 * @param url
	 * @return
	 */
	public static JSONObject executeGet(String url){		
		return executeMethod("", url, HttpMethod.GET);	
	}

	/**
	 * Execute a POST request
	 * @param url
	 * @param body
	 * @return
	 */	
	public static JSONObject executePost(String url, JSONObject body){		
		return executeMethod(body.toString(), url, HttpMethod.POST);	
	}
	
	/**
	 * Execute a PUT request
	 * @param url
	 * @param body
	 * @return
	 */	
	public static JSONObject executePut(String url, JSONObject body){		
		return executeMethod(body.toString(), url, HttpMethod.PUT);	
	}
	
	
	/**
	 * Executes a give HTTP method by calling an API URL. 
	 * @param body
	 * @param url
	 * @param httpMethod
	 * @return
	 */
	private static JSONObject executeMethod(String body, String url, HttpMethod httpMethod){
		HttpHeaders httpHeaders = RestUtils.createHeaders();		
		HttpEntity<String> entity = new HttpEntity<>(body, httpHeaders );
		ResponseEntity<String> re =  getRestTemplate().exchange(url, httpMethod,entity, String.class);
		JSONObject jSONObject = JSONObject.fromObject(re.getBody());			
		return jSONObject;
	}
	
	/**
	 * Creates a standard Spring RestTemplace class.
	 * Optionally, a proxy can be configured.  
	 * @return
	 */
	private static RestTemplate getRestTemplate(){		
		RestTemplate rt= new RestTemplate();		
		if(Configuration.USE_PROXY){
			SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		    Proxy proxy = new Proxy(Proxy.Type.HTTP, 
		    		new InetSocketAddress(Configuration.PROXY_HOST, Configuration.PROXY_PORT));
		    requestFactory.setProxy(proxy);
		    rt.setRequestFactory(requestFactory);
		}		
		return rt;
	}
	
	/**
	 * Creates the required HTTP headers for a REST api call for 
	 * posting a JSON object
	 * @return
	 */
	private static  HttpHeaders createHeaders(){
		HttpHeaders httpHeaders =  new HttpHeaders() {{
		         String auth = Configuration.USER_NAME + ":" + Configuration.PASSWORD;
		         byte[] encodedAuth = Base64.encodeBase64( 
		            auth.getBytes(Charset.forName("US-ASCII")) );
		         String authHeader = "Basic " + new String( encodedAuth );
		         set( "Authorization", authHeader );
		      }};
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
		      
		}

}
