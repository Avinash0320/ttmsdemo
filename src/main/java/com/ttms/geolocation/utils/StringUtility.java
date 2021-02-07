package com.ttms.geolocation.utils;

/**
 * Utility class to crater the string.
 * @author avinash
 *
 */
public class StringUtility {
	
	
	public static boolean isNotNull(String value) {
		return (value != null && value.trim().length() > 0) ? true : false;
	}

}
