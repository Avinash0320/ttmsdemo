package com.ttms.geolocation.controllers;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttms.geolocation.payload.ApiResponse;
import com.ttms.geolocation.services.ILocationService;

/**
 * To crater the incoming request with list of ip's inorder to provide the geo location
 * @author avinash
 *
 */
@RestController
@RequestMapping(value = "/api")
public class LocationControllers {
	
	private static final Logger _LOGGER  = LoggerFactory.getLogger(LocationControllers.class);

	@Autowired
	private ILocationService locationService;
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/ip")
	public ResponseEntity ipTracker(@RequestParam List<String> ips) {
		_LOGGER.info("IP : {}",ips);
		Set<String> countryNames = locationService.getCountryNames(ips);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.toString(), countryNames));
		
	}
}
