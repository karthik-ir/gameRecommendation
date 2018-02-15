/**
 * 
 */
package com.es.gameRecommendation.api.model;

import java.util.List;

/**
 * @author karthik
 *
 */
public class RecommendationResponse {

	List<String> recommendations;

	public RecommendationResponse(List<String> recommendations) {
		this.recommendations = recommendations;
	}

	public List<String> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<String> recommendations) {
		this.recommendations = recommendations;
	}

}
