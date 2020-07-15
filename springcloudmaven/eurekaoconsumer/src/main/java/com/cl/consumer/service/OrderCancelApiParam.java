package com.cl.consumer.service;

import lombok.Data;

import java.io.Serializable;

/**
 * by cl at 2020/7/8 0008
 */
@Data
public class OrderCancelApiParam implements Serializable {

    /**
     * 订单编号
     */
    private String orderNo;

}
