package com.cl.consumer.controller;

import com.cl.consumer.service.IHelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IHelloService helloService;

    private static final String applicationName = "single-provider";

    @RequestMapping(value = "feignRequest")
    public Object feignRequest(){
        String s = helloService.nice();
        return s;
    }
    @HystrixCommand(fallbackMethod = "indexError") // 断路器配置
    @RequestMapping(value = "commonRequest")
    public Object commonRequest(){
        String url = "http://"+ applicationName +"/hello";
        String s = restTemplate.getForObject(url,String.class);
        return s;
    }

    public Object indexError() {
        return "{\"code\": 999,\"message\": \"服务断路\"}";
    }
}
