package com.devsuperior.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2602.dto.CustomerDTO;
import com.devsuperior.uri2602.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  /*
   * SQL:
   * 
   * SELECT name
   * FROM customers
   * WHERE state = 'RS';
   * 
   */

  // JPQL
  @Query("SELECT new com.devsuperior.uri2602.dto.CustomerDTO(obj.name) "
      + "FROM Customer obj "
      + "WHERE UPPER(obj.state) = UPPER(:state)")
  List<CustomerDTO> searchByState(String state);
}
