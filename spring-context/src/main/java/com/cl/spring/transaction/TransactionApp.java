package com.cl.spring.transaction;

import java.util.Random;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * https://blog.csdn.net/xichenguan/article/details/78426696
 * @author HP
 *
 */
public class TransactionApp {
	@Test
	public void testTransaction() {
		String config = this.getClass().getPackage().getName().replace('.', '/') + "/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config);

		UserService userService = context.getBean(UserService.class);
		User user = getUser();
		userService.insert(user);
	}

	private User getUser() {
		int id = new Random().nextInt(1000000);
		User user = new User();
		user.setId(id);
		user.setName("Mary");
		user.setAge(27);
		return user;
	}
}
