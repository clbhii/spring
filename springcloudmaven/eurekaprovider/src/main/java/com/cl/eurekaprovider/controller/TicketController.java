package com.cl.eurekaprovider.controller;

import com.cl.eurekaprovider.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * by cl at 2020/6/23 0023
 */

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/")
    public String index(){
        return ticketService.buyTicket();
    }
}
