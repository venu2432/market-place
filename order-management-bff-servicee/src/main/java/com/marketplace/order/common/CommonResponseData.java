package com.marketplace.order.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CommonResponseData implements Serializable {
    private ResponseMessage responseMessage = new ResponseMessage();
    private Object responseData;
    private CommonErrorData errorData = new CommonErrorData();
    private String type;
    private String title;

    public CommonResponseData() {
    }
}








