package com.cl.spring.ioc.map.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MapServiceFactory {

	/**
	 * 可以自动装载
	 */
	@Autowired
	public Map<String, MapService> map;
	/**
	 * util:map 是当做配置项来管理的，所以用Resource注入
	 * 
	 */
	@Resource(name = "testMap")
	public Map<String, Map<String, String>> testMap;
	/**
	 * 而@Autowired 按类型注入的，
	 */
	@Autowired
	@Qualifier("testMap")
	public Map<String, Map<String, String>> testMapAutowired;
	

	@Resource(name = "testList")
	public List<String> testList;
	
	@Resource(name = "testMapLsit")
	public Map<String, List<String>> testMapList;
	
	@Resource(name = "testMapLsit2")
	public Map<String, List<String>> testMapLsit2;
	
	public void say() {
		
		for(Entry<String, MapService> entry : map.entrySet()){
			entry.getValue().say();
		}
		//print(testMap);
		System.out.println(testMap);
		System.out.println(testMapAutowired);
		System.out.println(testList);
		System.out.println(testMapList);
		System.out.println(testMapLsit2);
	}
	
	private void print(Map<String, Map<String, String>> testMap) {
		for(Entry<String, Map<String, String>> entry : testMap.entrySet()) {
			String key = entry.getKey();
			System.out.println("key:" + key);
			Map<String, String> value = entry.getValue();
			for(Entry<String, String> e : value.entrySet()) {
				System.out.println(e.getKey() + ":" + e.getValue());
			}
		}
	}
}
