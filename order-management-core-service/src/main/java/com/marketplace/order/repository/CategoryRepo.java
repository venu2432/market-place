package com.marketplace.order.repository;

import com.marketplace.order.constants.QueryConstants;
import com.marketplace.order.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    @Query(value = QueryConstants.GET_CATEGORY_BY_NAME, nativeQuery = true)
    List<Category> findByNameGiven(@Param("name") String name);
}
