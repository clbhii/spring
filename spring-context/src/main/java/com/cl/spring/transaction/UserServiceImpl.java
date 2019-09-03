package com.cl.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private ApplicationEventPublisher publisher;

  public void insert(User user) {
    jdbcTemplate.update("insert into user (id, name, age) value (?, ?, ?)", 
        user.getId(), user.getName(), user.getAge());
    
	if (TransactionSynchronizationManager.isActualTransactionActive()) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				 System.out.println("11 after commit, id ");
			}
		});
	}
    publisher.publishEvent(user);
  }
}
