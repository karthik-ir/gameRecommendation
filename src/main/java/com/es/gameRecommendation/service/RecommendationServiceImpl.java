/**
 * 
 */
package com.es.gameRecommendation.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.es.gameRecommendation.RecommendationException;
import com.es.gameRecommendation.api.model.CalculatedRecommendation;
import com.es.gameRecommendation.model.Customer;
import com.es.gameRecommendation.model.Recommendation;
import com.es.gameRecommendation.repository.CustomerRepository;

/**
 * @author karthik
 *
 */
@Component
public class RecommendationServiceImpl implements RecommendationService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CalculatedRecommendation getRecommendation(String customerID, int count) {

		Customer customer = customerRepository.findOne(Long.parseLong(customerID));
		customerRepository.findAll();
		if (customer == null)
			return null;

		CalculatedRecommendation cr = new CalculatedRecommendation();
		if (customer.getActiveRecommendation()) {
			customer.getCustomerRecommendations().stream().limit(count).forEach((r) -> {
				cr.getRecommendations().add(r.getRecommendation());
			});
			return cr;
		}else {
			return null;
		}
	}

	@Override
	public Boolean addRecommendations(byte[] fileBytes) throws RecommendationException {
		String line = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(fileBytes)));
		List<Customer> customers = new ArrayList<Customer>();
		try {
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",", 3);

				Long customerNumber = Long.parseLong(removeQuotes(split[0]));
				Boolean recommendationActive = Boolean.parseBoolean(removeQuotes(split[1]));

				Customer cust = new Customer(customerNumber, recommendationActive);
				List<Recommendation> recommendations = new ArrayList<>();

				Arrays.asList(split[2].split(",")).stream().parallel().forEach((rec) -> {
					recommendations.add(new Recommendation(removeQuotes(rec), cust));
				});
				cust.setCustomerRecommendations(recommendations);
				customers.add(cust);
			}
			
			customers.forEach((cust)->{
				customerRepository.save(cust);
			});
			
			return true;
		} catch (IOException e) {
			throw new RecommendationException(e);
		}
	}

	private String removeQuotes(String line) {
		return line.replaceAll("^\"|\"$", "");
	}
}
