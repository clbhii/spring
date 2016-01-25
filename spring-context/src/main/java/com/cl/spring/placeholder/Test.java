package com.cl.spring.placeholder;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws IOException {
		String config = Test.class.getPackage().getName().replace('.', '/') + "/applicationContext.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(config);
		
		for(int i=0;i<3;i++){
			Artist  actor=(Artist)context.getBean("actor"+i);
			actor.act();
		}
		
		
	}

}
