package com.cl.spring.mvc;

import org.hibernate.validator.constraints.NotEmpty;

public class Person {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@NotEmpty
	private String name;
	private int age;
	private User user;
}
