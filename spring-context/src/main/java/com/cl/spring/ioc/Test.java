package com.cl.spring.ioc;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.spring.ioc.service.StoreService;

public class Test {
	public void applicationContext(){
		String config = this.getClass().getPackage().getName().replace('.', '/') + "/applicationContext.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(config);
		StoreService service = (StoreService)context.getBean("storeService");
		service.submitOrder();
		
		Map env=(Map)context.getBean("env");
		System.out.println(env.get("JAVA_HOME"));
		System.out.println(context.getBean("env2"));
	}
	
	public void applicationContext_autowire(){
		String config = this.getClass().getPackage().getName().replace('.', '/') + "/applicationContext_autowire.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(config);
		StoreService service = (StoreService)context.getBean("storeService");
		service.submitOrder();
	}
	
	public void applicationContext1(){
		String config = this.getClass().getPackage().getName().replace('.', '/') + "/applicationContext1.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(config);
		StoreService service = (StoreService)context.getBean("storeService");
		service.submitOrder();
	}
	
	public void applicationContext1_parent(){
		String config = this.getClass().getPackage().getName().replace('.', '/') + "/applicationContext1_parent.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(config);
		StoreService service = (StoreService)context.getBean("storeService");
		service.submitOrder();
		StoreService storeService1 = (StoreService)context.getBean("storeService1");
		storeService1.submitOrder();
		
	}
	
	
	
	public static void main(String[] args) {
		Test test = new Test();
//		test.applicationContext();
		test.applicationContext_autowire();
//		test.applicationContext1();
//		test.applicationContext1_parent();

	}

}
