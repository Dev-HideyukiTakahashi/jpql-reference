package com.devsuperior.uri2609.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  /*
   * SQL:
   * 
   * SELECT categories.name, SUM(products.amount)
   * FROM products
   * INNER JOIN categories
   * ON products.id_categories = categories.id
   * GROUP BY categories.name;
   * 
   */

  // JPQL:

  @Query("SELECT new com.devsuperior.uri2609.dto.CategorySumDTO(obj.category.name, SUM(obj.amount)) "
      + "FROM Product obj "
      + "GROUP BY obj.category.name")
  List<CategorySumDTO> amountGroupedByCategory();
}
