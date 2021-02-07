package com.ttms.geolocation.exceptions.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.ttms.geolocation.exceptions.LocationException;
import com.ttms.geolocation.payload.ApiExceptionResponse;

/**
 * Resolve localized error message. Utility method to generate a localized error message
 * 
 */
@RestControllerAdvice
public class APIExceptionControllerAdvice {

	private final static Logger _LOGGER = LoggerFactory.getLogger(APIExceptionControllerAdvice.class);

	private final MessageSource messageSource;

	@Autowired
	public APIExceptionControllerAdvice(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
    private String resolvePathFromWebRequest(WebRequest request) {
        try {
            return ((ServletWebRequest) request).getRequest().getAttribute("javax.servlet.forward.request_uri").toString();
        } catch (Exception ex) {
            return null;
        }
    }
	
    @ExceptionHandler(value = LocationException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ResponseBody
    public ApiExceptionResponse locationException(LocationException ex, WebRequest request) {
        return new ApiExceptionResponse(false, ex.getMessage(), ex.getClass().getName(), resolvePathFromWebRequest(request));
    }
    

}
