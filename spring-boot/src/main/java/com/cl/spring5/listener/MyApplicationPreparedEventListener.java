package com.cl.spring5.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 上下文创建完成后执行的事件监听器
 * 
 * @author HP
 *
 */
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
	private Logger logger = LoggerFactory.getLogger(MyApplicationPreparedEventListener.class);

	public void onApplicationEvent(ApplicationPreparedEvent event) {
		ConfigurableApplicationContext cac = event.getApplicationContext();
		passContextInfo(cac);
	}

	/**
	 * 传递上下文
	 * 
	 * @param cac
	 */
	private void passContextInfo(ApplicationContext cac) {
		// dosomething()
		logger.info("上下文创建完成后执行的事件监听器");
	}

}
