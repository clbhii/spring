package com.cl.spring5.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * pring boot启动异常时执行事件 
 * @author HP
 *
 */
public class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

    public void onApplicationEvent(ApplicationFailedEvent event) {
        Throwable throwable = event.getException();
        handleThrowable(throwable);
    }

    /*处理异常*/
    private void handleThrowable(Throwable throwable) {
    }

}
