package com.cl.spring.ioc.map.service;

import org.springframework.stereotype.Service;

@Service
public class Map2Service implements MapService{

	public void say() {
		System.out.println("map2");
	}

}
