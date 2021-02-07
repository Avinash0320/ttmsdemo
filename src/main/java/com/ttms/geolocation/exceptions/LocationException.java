package com.ttms.geolocation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author avinash
 *
 */
@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public final class LocationException extends RuntimeException{

	public LocationException() {
        super();
    }

    public LocationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public LocationException(final String message) {
        super(message);
    }

    public LocationException(final Throwable cause) {
        super(cause);
    }

}
