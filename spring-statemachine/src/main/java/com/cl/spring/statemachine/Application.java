package com.cl.spring.statemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
@Configuration
public class Application  {
private Logger logger = LoggerFactory.getLogger(getClass());
	
	
  public static void main(String[] args) {
	  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	  context.register(StateMachineConfig.class);
//	  context.register(EventConfig.class);
	  context.register(Application.class);
	  context.refresh();
	  Application application = context.getBean(Application.class);
	  application.run();
  }

  @Autowired
  private StateMachine<States, Events> stateMachine;

  public void run()  {
	  logger.info("开始");
      stateMachine.start();
      logger.info("付款");
      stateMachine.sendEvent(Events.PAY);
      logger.info("收货");
      stateMachine.sendEvent(Events.RECEIVE);
  }

}

