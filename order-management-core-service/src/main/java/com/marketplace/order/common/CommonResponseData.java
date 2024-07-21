package com.marketplace.order.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponseData implements Serializable {
    private ResponseMessage responseMessage = new ResponseMessage();
    private Object responseData;
    private CommonErrorData errorData = new CommonErrorData();
    private String type;
    private String title;

    public CommonResponseData() {
    }

    public ResponseMessage getResponseMessage() {
        return this.responseMessage;
    }

    public Object getResponseData() {
        return this.responseData;
    }

    public CommonErrorData getErrorData() {
        return this.errorData;
    }

    public String getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }


    public void setResponseMessage(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

    public void setErrorData(CommonErrorData errorData) {
        this.errorData = errorData;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}








