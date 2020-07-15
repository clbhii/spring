package com.cl.consumer.service;

import com.cl.consumer.common.Result;
import com.cl.consumer.common.ResultSupport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("wyn-provider")
public interface IOrderService {

    @RequestMapping(value = "/order/cancelOrder",method = RequestMethod.POST)
    ResultSupport cancelOrder(OrderCancelApiParam orderCancelApiParam);
    @RequestMapping(value = "/order/confirmBooking",method = RequestMethod.POST)
    ResultSupport confirmBooking(OrderConfirmBookingApiParam orderConfirmBookingApiParam);
}
