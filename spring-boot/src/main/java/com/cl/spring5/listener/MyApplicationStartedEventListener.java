package com.cl.spring5.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
/**
 * spring boot 启动监听类
 * @author HP
 *
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

	private Logger logger = LoggerFactory.getLogger(MyApplicationEnvironmentPreparedEventListener.class);

    public void onApplicationEvent(ApplicationStartedEvent event) {
        SpringApplication app = event.getSpringApplication();
        //app.setShowBanner(false);// 不显示banner信息
        logger.info("==MyApplicationStartedEventListener==");
        System.out.println("==MyApplicationStartedEventListener==");
    }
}
