package com.cl.consumer.controller;


import com.cl.consumer.util.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * by cl at 2020/7/2 0002
 */
@Slf4j
public class OrderControllerTest {
    String url = "http://localhost:3002/";

    @Test
    public void confirmBooking() {
        Map<String, String> map = new HashMap<>();
        map.put("hotelId", "JD729607920626434048");
        map.put("roomId","JD729607922312544258");
        map.put("inDate", "2020-07-06");
        map.put("outDate", "2020-07-08");
        map.put("roomNum", "1");
        map.put("guestCount","1");
        map.put("totalPrice", "166");

        String post = HttpUtil.post(url + "order/confirmBooking", new HashMap<>(), map);
        log.info(post);

    }

    @Test
    public void cancelOrder(){
        Map<String, String> map = new HashMap<>();
        map.put("orderNo", "12312");
        String post = HttpUtil.post(url + "order/cancelOrder", new HashMap<>(), map);
        log.info(post);
    }
}
