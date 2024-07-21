package com.marketplace.order.common;

import com.marketplace.order.constants.OrderConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;

import java.util.Arrays;

@Slf4j
public class OrderExceptionUtil {
    public static void handleException(Throwable e,String endPoint){
        if(e instanceof BadRequestException){
            log.error(OrderConstants.FOUND_BAD_EXCEPTION + "{}" + OrderConstants.LOG_MSG_STRING + "{}", endPoint, e.getMessage());
        }
        else{
            log.error(OrderConstants.FOUND_EXCEPTION + "{}" + OrderConstants.LOG_MSG_STRING + "{}" + OrderConstants.LOG_TRACE_STRING + "{}", endPoint, e.getMessage(), Arrays.stream(e.getStackTrace()));
        }
    }
}
