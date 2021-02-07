package com.ttms.geolocation.payload;

import java.util.Set;

/**
 * Generic API Response
 * @author avinash
 *
 */
public class ApiResponse {
	
	private String statusCode;
	private Set<String> results;
	
	public ApiResponse(String code,Set<String> results) {
		
		this.statusCode = code;
		this.results = results;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Set<String> getResults() {
		return results;
	}

	public void setResults(Set<String> results) {
		this.results = results;
	}
	
}
