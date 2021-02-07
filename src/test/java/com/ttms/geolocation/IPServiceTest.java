package com.ttms.geolocation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.ttms.geolocation.exceptions.LocationException;
import com.ttms.geolocation.services.ILocationService;


public class IPServiceTest {
	
	@Autowired
	private ILocationService locationService;
	
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
    }
	
	@Test
	public void validateIPServiceAcceptsMin1Ips() {
		
		List<String> noIPList = new ArrayList<String>();
		locationService.getCountryNames(noIPList);
		thrown.expect(LocationException.class);
		thrown.expectMessage("API accept min 1 max 5 ip's ");
	}

}
