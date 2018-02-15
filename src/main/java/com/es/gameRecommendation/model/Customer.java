/**
 * 
 */
package com.es.gameRecommendation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author karthik
 *
 */

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	Long cutomerNumber;

	Boolean activeRecommendation = false;
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	List<Recommendation> customerRecommendations;

	public Customer() {
		
	}
	
	public Customer(Long cutomerNumber, Boolean activeRecommendation) {
		super();
		this.cutomerNumber = cutomerNumber;
		this.activeRecommendation = activeRecommendation;
	}

	public Long getCutomerNumber() {
		return cutomerNumber;
	}

	public void setCutomerNumber(Long cutomerNumber) {
		this.cutomerNumber = cutomerNumber;
	}

	public Boolean getActiveRecommendation() {
		return activeRecommendation;
	}

	public void setActiveRecommendation(Boolean activeRecommendation) {
		this.activeRecommendation = activeRecommendation;
	}

	public List<Recommendation> getCustomerRecommendations() {
		return customerRecommendations;
	}

	public void setCustomerRecommendations(List<Recommendation> customerRecommendations) {
		this.customerRecommendations = customerRecommendations;
	}

}
