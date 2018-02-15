/**
 * 
 */
package com.es.gameRecommendation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.es.gameRecommendation.model.Customer;

/**
 * @author karthik
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
