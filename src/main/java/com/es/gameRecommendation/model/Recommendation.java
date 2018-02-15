/**
 * 
 */
package com.es.gameRecommendation.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author karthik
 *
 */
@Entity
@Table(name = "recommendations")
public class Recommendation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	String recommendation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	Customer customer;

	public Recommendation() {
		// TODO Auto-generated constructor stub
	}
	
	public Recommendation(String recommendation, Customer customer) {
		super();
		this.recommendation = recommendation;
		this.customer = customer;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
