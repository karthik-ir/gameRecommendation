package com.es.gameRecommendation.service;

import org.springframework.stereotype.Service;

import com.es.gameRecommendation.RecommendationException;
import com.es.gameRecommendation.api.model.CalculatedRecommendation;

@Service
public interface RecommendationService {

	Boolean addRecommendations(byte[] fileBytes) throws RecommendationException;

	CalculatedRecommendation getRecommendation(String customerID, int count);

}
