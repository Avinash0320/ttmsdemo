package com.ttms.geolocation.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author avinash
 *
 */
public class CountriesUtils {

	
	/**
	 * List of counties in northern hemisphere
	 * @return
	 */
	public static Map<String, String> getNorthernHemisphereCountriesMap(){
		Map<String, String> countriesMap = new HashMap<String, String>();
		countriesMap.put("Austria", "Austria");
		countriesMap.put("Belgium", "Belgium");
		countriesMap.put("Bulgaria", "Bulgaria");
		countriesMap.put("China", "China");
		countriesMap.put("France", "France");
		countriesMap.put("Germany", "Germany");
		countriesMap.put("Hungary", "Hungary");
		countriesMap.put("India", "India");
		countriesMap.put("Japan", "Japan");
		countriesMap.put("Mexico", "Mexico");
		countriesMap.put("Netherlands", "Netherlands");
		countriesMap.put("Norway", "Norway");
		countriesMap.put("Poland", "Poland");
		countriesMap.put("Romania", "Romania");
		countriesMap.put("Russia", "Russia");
		countriesMap.put("Spain", "Spain");
		countriesMap.put("Sweden", "Sweden");
		countriesMap.put("Switzerland", "Switzerland");
		countriesMap.put("United Kingdom", "United Kingdom");
		countriesMap.put("Ukraine", "Ukraine");
		countriesMap.put("Canada", "Canada");
		countriesMap.put("United States", "United States");
		return countriesMap;
	}
}
