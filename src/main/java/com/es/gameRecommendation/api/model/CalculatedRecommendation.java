/**
 * 
 */
package com.es.gameRecommendation.api.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author karthik
 *
 */
public class CalculatedRecommendation {

	List<String> recommendations;

	public CalculatedRecommendation() {
		recommendations = new ArrayList<>();
	}

	public List<String> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<String> recommendations) {
		this.recommendations = recommendations;
	}

}
