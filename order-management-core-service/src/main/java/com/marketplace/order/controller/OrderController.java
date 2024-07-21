package com.marketplace.order.controller;

import com.marketplace.order.common.CommonResponse;
import com.marketplace.order.common.CommonResponseData;
import com.marketplace.order.entities.Category;
import com.marketplace.order.entities.Product;
import com.marketplace.order.model.ProductNameDTO;
import com.marketplace.order.service.OrderMgmtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("ordermgmt")
public class OrderController {

    @Autowired
    OrderMgmtService orderMgmtService;

    @PostMapping("order-mgmt/searchProduct")
    public ResponseEntity<CommonResponseData> searchProducts(@RequestBody ProductNameDTO requestBody){
        String endPoint = "searchProduct";
        Timestamp landingTime = Timestamp.valueOf(LocalDateTime.now());
        List<Product> responseList  = orderMgmtService.searchProduct(requestBody.getProductName());
        log.info("result is:{}",responseList.toString());
        return CommonResponse.sendResponse(responseList,landingTime, HttpStatus.OK,200,"SUCCESS",endPoint);
    }

    @PostMapping("v1.0/getProductById")
    public ResponseEntity<CommonResponseData> getProductById(@RequestBody ProductNameDTO request){
        String endPoint = "getProductById";
        Timestamp landingTime = Timestamp.valueOf(LocalDateTime.now());
        Optional<Product> response = orderMgmtService.getProductById(request.getId());
        return CommonResponse.sendResponse(response,landingTime,HttpStatus.OK,200,"SUCCESS",endPoint);
    }

    @GetMapping("v1.0/getCategory")
    public ResponseEntity<CommonResponseData> getCategory(@RequestBody ProductNameDTO request){
        String endPoint = "getProductById";
        Timestamp landingTime = Timestamp.valueOf(LocalDateTime.now());
        List<Category> response = orderMgmtService.getCategory(request.getCategoryName());
        return CommonResponse.sendResponse(response,landingTime,HttpStatus.OK,200,"SUCCESS",endPoint);
    }
}
