package com.cl.eurekaprovider.service;

import org.springframework.stereotype.Service;

/**
 * by cl at 2020/6/23 0023
 */
@Service
public class TicketService {

    public String buyTicket() {
        System.out.println("我是8002");
        return "《疯狂的石头》";
    }
}
