package com.cl.spring.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
@Configuration
public class Application  {

  public static void main(String[] args) {
	  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	  context.register(StateMachineConfig.class);
	  context.register(Application.class);
	  context.refresh();
	  Application application = context.getBean(Application.class);
	  application.run();
  }

  @Autowired
  private StateMachine<States, Events> stateMachine;

  public void run()  {
      stateMachine.start();
      stateMachine.sendEvent(Events.PAY);
      stateMachine.sendEvent(Events.RECEIVE);
  }

}

