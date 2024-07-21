package com.marketplace.order.service;

import com.marketplace.order.entities.Category;
import com.marketplace.order.entities.Product;
import com.marketplace.order.repository.CategoryRepo;
import com.marketplace.order.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderMgmtServiceImpl implements OrderMgmtService{

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public List<Product> searchProduct(String name) {
        List<Product> reponseList = productRepo.findByNameGiven(name);
        return reponseList;
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepo.findById(id);
    }

    @Override
    public List<Category> getCategory(String name) {
        return categoryRepo.findByNameGiven(name);
    }
}
