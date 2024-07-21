package com.marketplace.order.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CommonResponse {
    public CommonResponse(){

    }
    public static ResponseEntity<CommonResponseData> sendResponse(Object object, Timestamp landingTime, HttpStatus status, Integer actualStatus, String type, String title) {
        CommonResponseData response = new CommonResponseData();
        response.getResponseMessage().setLandingTime(landingTime);
        response.getResponseMessage().setResponseTime(Timestamp.valueOf(LocalDateTime.now()));
        response.getResponseMessage().setMessage("SUCCESS");
        response.getResponseMessage().setStatus(0);
        response.getResponseMessage().setHttpStatus(actualStatus);
        response.setResponseData(object);
        response.setType(type);
        response.setTitle(title);
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<CommonResponseData> sendErrorResponse(String errorCode, String errorMessage, Timestamp landingTime, HttpStatus status, Integer actualStatus) {
        CommonResponseData errorResponse = new CommonResponseData();
        errorResponse.getResponseMessage().setLandingTime(landingTime);
        errorResponse.getResponseMessage().setResponseTime(Timestamp.valueOf(LocalDateTime.now()));
        errorResponse.getResponseMessage().setMessage("FAILURE");
        errorResponse.getErrorData().setErrorCode(errorCode);
        errorResponse.getErrorData().setErrorMessage(errorMessage);
        errorResponse.getResponseMessage().setStatus(1);
        errorResponse.getResponseMessage().setHttpStatus(actualStatus);
        return new ResponseEntity<>(errorResponse, status);
    }
}
