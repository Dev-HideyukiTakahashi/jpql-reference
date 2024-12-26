package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  /*
   * SQL:
   * 
   * SELECT products.name
   * FROM products
   * INNER JOIN providers
   * ON providers.id = products.id_providers
   * WHERE products.amount BETWEEN 10 AND 20
   * AND providers.name LIKE 'P%';
   * 
   */

  @Query("SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) "
      + "FROM Product obj "
      + "WHERE obj.amount BETWEEN :min AND :max "
      + "AND obj.provider.name LIKE CONCAT(:startsWith,'%')")
  List<ProductMinDTO> search1(Integer min, Integer max, String startsWith);
}
