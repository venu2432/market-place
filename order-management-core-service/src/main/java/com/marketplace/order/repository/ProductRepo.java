package com.marketplace.order.repository;

import com.marketplace.order.constants.QueryConstants;
import com.marketplace.order.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query(value = QueryConstants.GET_PRODUCT_BY_NAME, nativeQuery = true)
    List<Product> findByNameGiven(@Param("name") String name);

}
