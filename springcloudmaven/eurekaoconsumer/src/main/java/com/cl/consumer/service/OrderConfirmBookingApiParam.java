package com.cl.consumer.service;


import lombok.Data;

import java.io.Serializable;

/**
 * by cl at 2020/7/2 0002
 */
@Data
public class OrderConfirmBookingApiParam implements Serializable {

    /**
     * ots平台酒店编号
     */

    private String hotelId;

    /**
     * ots平台房型编号
     */
    private String roomId;
    /**
     * 入住时间2017-01-05
     */
    private String inDate;
    /**
     * 离店时间2017-01-07
     */
    private String outDate;
    /**
     * 预定间数
     */
    private String roomNum;
    /**
     *入住总人数
     */
    private String guestCount;
    /**
     * 订单总价
     */
    private String totalPrice;


}
