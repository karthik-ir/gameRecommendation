/**
 * 
 */
package com.es.gameRecommendation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author karthik
 *
 */

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RecommendationException extends Exception {

	/**
	 * 
	 */
	public RecommendationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public RecommendationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public RecommendationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RecommendationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RecommendationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
