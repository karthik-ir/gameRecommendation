/**
 * 
 */
package com.es.gameRecommendation.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.es.gameRecommendation.RecommendationException;
import com.es.gameRecommendation.api.model.RecommendationResponse;
import com.es.gameRecommendation.api.model.CalculatedRecommendation;
import com.es.gameRecommendation.service.RecommendationService;

/**
 * @author karthik
 *
 */
@RestController(value = "")
public class RecommendationController {

	@Autowired
	RecommendationService recommendationService;

	@RequestMapping(value = "/customers/{customerID}/games/recommendations", method = RequestMethod.GET)
	public ResponseEntity<RecommendationResponse> getRecommendations(
			@PathVariable(name = "customerID") String customerID,
			@RequestParam(value = "count", required = false, defaultValue = "5") int count) {

		CalculatedRecommendation recommendation = recommendationService.getRecommendation(customerID, count);
		if (recommendation == null)
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<RecommendationResponse>(
				new RecommendationResponse(recommendation.getRecommendations()), HttpStatus.OK);
	}

	@RequestMapping(value = "/upload")
	public ResponseEntity<String> postCsv(@RequestParam("file") MultipartFile file) throws RecommendationException {

		if (file.isEmpty()) {
			return new ResponseEntity<String>("Please select a file to upload", HttpStatus.BAD_REQUEST);
		}

		try {
			if (recommendationService.addRecommendations(file.getBytes())) {
				return new ResponseEntity<String>("Uploaded successfully " + file.getOriginalFilename(),
						HttpStatus.CREATED);
			} else {
				throw new RecommendationException("Something went wrong");
			}
		} catch (IOException e) {
			throw new RecommendationException(e);
		}
	}

}
