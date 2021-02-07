package com.ttms.geolocation.services;

import java.util.List;
import java.util.Set;

public interface ILocationService {

	/**
	 * @param ips
	 * @return
	 */
	public Set<String> getCountryNames(List<String> ips);
}
