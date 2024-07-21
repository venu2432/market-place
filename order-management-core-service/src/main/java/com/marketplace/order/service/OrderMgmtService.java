package com.marketplace.order.service;

import com.marketplace.order.entities.Category;
import com.marketplace.order.entities.Product;

import java.util.List;
import java.util.Optional;

public interface OrderMgmtService {
    List<Product> searchProduct(String name);
    Optional<Product> getProductById(Integer id);
    List<Category> getCategory(String name);
}
