package com.marketplace.order.common;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ResponseMessage {
    private Timestamp landingTime;
    private Timestamp responseTime;
    private String message;
    private Integer status;
    private Integer httpStatus;
}
