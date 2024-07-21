package com.marketplace.order.controller;

import com.marketplace.order.client.OrderManagmentCoreClient;
import com.marketplace.order.common.CommonResponse;
import com.marketplace.order.common.CommonResponseData;
import com.marketplace.order.common.OrderExceptionUtil;
import com.marketplace.order.model.ProductNameDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@RequestMapping("order-management")
@RestController
public class OrderManagementController {

    @Autowired
    OrderManagmentCoreClient orderManagmentCoreClient;

    @PostMapping("searchProducts")
    public ResponseEntity<CommonResponseData> searchProducts(HttpServletRequest httpServletRequest, @RequestBody ProductNameDTO request){
        String endPoint = "searchBooks";
        CommonResponseData responseData = new CommonResponseData();
        try{
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            ResponseEntity<CommonResponseData> response = orderManagmentCoreClient.searchProduct(request);
            if (response != null) {
                responseData.setResponseData(response.getBody().getResponseData());
            }
            return CommonResponse.sendResponse(responseData.getResponseData(),timestamp,HttpStatus.OK,200,"SUCCESSFUL",endPoint);
        }
        catch (Exception e){
            OrderExceptionUtil.handleException(e,endPoint);
            throw e;
        }
    }
}
