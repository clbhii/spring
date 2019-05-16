package com.cl.spring.statemachine;

import java.util.EnumSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

/**
 * 订单状态机配置
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
            .withStates()
                .initial(States.UNPAID)   
                .state(States.WAITING_FOR_RECEIVE, new Action<States, Events>() {
					public void execute(StateContext<States, Events> context) {
						logger.info("doAction entry state");
					}
				}, new Action<States, Events>() {
					public void execute(StateContext<States, Events> context) {
						logger.info("doAction exit state");
					}
				})
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(States.UNPAID).target(States.WAITING_FOR_RECEIVE)
                .event(Events.PAY)
                .action(action())
//                .action(actionException(), errorAction())
                .guard(guard())
                .and()
            .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Events.RECEIVE);
    }

    @Bean
    public Guard<States, Events> guard() {
        return new Guard<States, Events>() {

            @Override
            public boolean evaluate(StateContext<States, Events> context) {
            	logger.info("Guard");
                return true;
            }
        };
    }
    @Bean
    public Action<States, Events> action() {
        return new Action<States, Events>() {

            @Override
            public void execute(StateContext<States, Events> context) {
            	logger.info("doAction");
            }
        };
    }
    @Bean
    public Action<States, Events> actionException() {
        return new Action<States, Events>() {

            @Override
            public void execute(StateContext<States, Events> context) {
                throw new RuntimeException("MyError");
            }
        };
    }
    @Bean
    public Action<States, Events> errorAction() {
        return new Action<States, Events>() {

            @Override
            public void execute(StateContext<States, Events> context) {
                // RuntimeException("MyError") added to context
                Exception exception = context.getException();
                exception.getMessage();
            }
        };
    }
    
    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
            .withConfiguration()
                .listener(listener());
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {

            @Override
			public void stateChanged(State<States, Events> from, State<States, Events> to) {
            	logger.info("触发stateChanged={}, target={}", from == null ? "": from.getId(), to == null ? "": to.getId());
			}

			@Override
            public void transition(Transition<States, Events> transition) {
            	State<States, Events> source = transition.getSource();
            	State<States, Events> target = transition.getTarget();
            	logger.info("触发transition:source={}, target={}", 
            			source == null ? "": source.getId(), target == null ? "": target.getId());
                if(target.getId() == States.UNPAID) {
                    logger.info("订单创建，待支付");
                    return;
                }

                if(source.getId() == States.UNPAID
                        && target.getId() == States.WAITING_FOR_RECEIVE) {
                    logger.info("用户完成支付，待收货");
                    return;
                }

                if(source.getId() == States.WAITING_FOR_RECEIVE
                        && target.getId() == States.DONE) {
                    logger.info("用户已收货，订单完成");
                    return;
                }
            }

        };
    }

}
