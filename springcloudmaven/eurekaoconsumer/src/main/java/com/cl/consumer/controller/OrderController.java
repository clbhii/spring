package com.cl.consumer.controller;

import com.cl.consumer.common.Result;
import com.cl.consumer.service.IOrderService;
import com.cl.consumer.service.OrderCancelApiParam;
import com.cl.consumer.service.OrderConfirmBookingApiParam;
import com.cl.consumer.util.json.JacksonBuilder;
import com.cl.consumer.util.json.JacksonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * by cl at 2020/7/8 0008
 */
@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private IOrderService orderService;

    private ObjectMapper objectMapper = new JacksonBuilder().build();

    @RequestMapping("/cancelOrder")
    public Result cancelOrder(OrderCancelApiParam orderCancelApiParam){
        Result result = orderService.cancelOrder(orderCancelApiParam);
        return result;
    }
    @RequestMapping("/confirmBooking")
    public Result confirmBooking(OrderConfirmBookingApiParam orderConfirmBookingApiParam){
        log.info(JacksonUtils.objectToJson(objectMapper, orderConfirmBookingApiParam));
        Result result = orderService.confirmBooking(orderConfirmBookingApiParam);
        return result;
    }
}
