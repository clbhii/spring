package com.cl.spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cl.spring5.listener.MyApplicationEnvironmentPreparedEventListener;
import com.cl.spring5.listener.MyApplicationPreparedEventListener;
import com.cl.spring5.listener.MyApplicationStartedEventListener;
/**
 * https://www.cnblogs.com/ityouknow/p/5662753.html
 * https://blog.csdn.net/liaokailin/article/category/5765237
 * @author HP
 *
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class); 
		app.addListeners(new MyApplicationStartedEventListener());
		app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
		app.addListeners(new MyApplicationPreparedEventListener());
		app.run(args);
	}

}

