package com.marketplace.order.client;

import com.marketplace.order.common.CommonResponseData;
import com.marketplace.order.model.ProductNameDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "OrderMgmtCoreClient" , url = "${order.core.url}")
public interface OrderManagmentCoreClient {

    @PostMapping(value = "ordermgmt/order-mgmt/searchProduct")
    public ResponseEntity<CommonResponseData> searchProduct(@RequestBody ProductNameDTO productNameDTO);

}
