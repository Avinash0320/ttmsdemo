package com.ttms.geolocation.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttms.geolocation.exceptions.LocationException;
import com.ttms.geolocation.payload.IPResponse;
import com.ttms.geolocation.services.ILocationService;
import com.ttms.geolocation.utils.CountriesUtils;
import com.ttms.geolocation.utils.RestTemplateUtils;
import com.ttms.geolocation.utils.StringUtility;

@Service
public class LocationServiceImpl implements ILocationService {
	
	private final static Logger _LOGGER = LoggerFactory.getLogger(LocationException.class);

	@Value("${ip.api.url}")
	private String ip_api_url;

	/**
	 *To get the countries names in northern hemisphere
	 */
	@Override
	public Set<String> getCountryNames(List<String> ips) {

		RestTemplate template = null;
		ResponseEntity<String> response = null;

		try {
			
			if (ips.size() >= 1 && ips.size() <= 5) {
				
				template = RestTemplateUtils.restTemplate();
				
				//POST object with request body
				response = template.postForEntity(ip_api_url, ips, String.class);
				
				ObjectMapper mapper = new ObjectMapper();
				List<IPResponse> responseList = Arrays.asList(mapper.readValue(response.getBody(), IPResponse[].class));
				return responseList.stream().filter(res -> StringUtility.isNotNull(res.getCountry()) &&StringUtility.isNotNull(CountriesUtils.getNorthernHemisphereCountriesMap().get(res.getCountry()))).
						map(IPResponse::getCountry).
						sorted(Comparator.comparing(String::toString)).collect(Collectors.toSet());
				 
			} 
			 else {

				 throw new LocationException("API accept min 1 max 5 ip's ");
				 
			}
		} catch (Exception e) {
			_LOGGER.error("Exception caught while processing ip's: {} ",e.getMessage());
			e.printStackTrace();
			throw new LocationException(e.getLocalizedMessage());
			
		}
	}

}
